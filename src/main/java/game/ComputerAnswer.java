package game;

import reader.Reader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ComputerAnswer {

    private static ArrayList<String> words;
    private static HashSet<String> usedWords = new HashSet<>();


    ComputerAnswer() {
        words = new ArrayList<>(
                new Reader().readFile("src\\main\\resources\\Cities").stream()
                        .map(String::toUpperCase).toList()
        );
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

    public void showList() {
        System.out.println(words.toString());
    }

    private void addToUsedList(String word) {
        usedWords.add(word);
    }

    private String getCityName(String firstCityName) {

        Research research = new Research();

        char lastLetter = research.findLastLetter(firstCityName);
        List<String> temp = words.stream().filter(str -> str.charAt(0) == lastLetter)
                            .toList();

        temp = research.findNotUsedWord(temp);

        return !temp.isEmpty() ? temp.getFirst() : "Немає назви";

    }

    static class Research {

        public char findLastLetter(String input) {
            for (int i = 1; i < input.length(); i++) {
                char lastLetter = input.strip().charAt(input.length() - i);

                for (String name: words) {
                    if(name.charAt(0) == lastLetter){
                        return lastLetter;
                    }
                }
            }

            return ' ';
        }

        public List<String> findNotUsedWord(List<String> list) {
            return list.stream()
                    .filter(str -> !usedWords.contains(str))
                    .toList();
        }

    }
}
