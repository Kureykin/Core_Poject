package game;

import reader.Reader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class ComputerAnswer {

    private ArrayList<String> notUsedWords;
    private ArrayList<String> usedWords = new ArrayList<>();

    ComputerAnswer() {
        notUsedWords = new ArrayList<>(new Reader().readFile("C:\\Users\\kurey\\IdeaProjects\\Core_Poject\\src\\main\\resources\\Cities"));
    }

    public String computersTurn(String input) {
        String compAnswer;


        deleteUsedWord(input);

        compAnswer = getCityName(input);
        deleteUsedWord(compAnswer);

        return compAnswer;
    }

    public void showList() {
        System.out.println(notUsedWords.toString());
    }

    private void deleteUsedWord(String word) {
        notUsedWords.remove(word);
    }

    private String getCityName(String firstCityName) {

        String lastLetter = "" + firstCityName.charAt(firstCityName.length() - 1);
        List<String> temp = notUsedWords.stream().filter(str -> str.contains(lastLetter.toUpperCase()))
                            .toList();

        return !temp.isEmpty() ? temp.getFirst(): "Немає назви";

    }

}
