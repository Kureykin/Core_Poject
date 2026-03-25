package game;

import reader.Reader;
import reader.ReaderException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ComputerAnswerFinder {

    private static ArrayList<String> words;
    private static HashSet<String> usedWords = new HashSet<>();
    private static final  String ukrainianAlphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";

    ComputerAnswerFinder() {
        try {
            words = new ArrayList<>(new Reader().readFile().stream().map(String::toUpperCase).toList());
        } catch (ReaderException e) {
            throw new RuntimeException(e);
        }
    }

    private static char findLastLetter(String input) {
        for (int i = 1; i < input.length(); i++) {
            char lastLetter = input.strip().toUpperCase().charAt(input.length() - i);

            if (!ukrainianAlphabet.contains("" + lastLetter)) {
                continue;
            }

            for (String name: words) {
                if(name.charAt(0) == lastLetter){
                    return lastLetter;
                }
            }
        }

        return ' ';
    }
    private static List<String> findNotUsedWord(List<String> list) {
        return list.stream()
                .filter(str -> !usedWords.contains(str))
                .toList();
    }

    public String computersTurn(String input) {
        String compAnswer;

        if(!words.contains(input)) {
            JOptionPane.showMessageDialog(null, "Не вiдома назва");
            return "";
        }

       if(!usedWords.contains(input)){
           addToUsedList(input);
           compAnswer = getCityName(input);
           addToUsedList(compAnswer);
       }
       else {
           compAnswer = "Це вже було";
       }

        return compAnswer;
    }

    private void addToUsedList(String word) {
        usedWords.add(word);
    }

    private String getCityName(String firstCityName) {

        char lastLetter = findLastLetter(firstCityName);
        List<String> temp = words.stream().filter(str -> str.charAt(0) == lastLetter)
                            .toList();

        temp = findNotUsedWord(temp);

        return !temp.isEmpty() ? temp.getFirst() : "Немає назви";

    }



}
