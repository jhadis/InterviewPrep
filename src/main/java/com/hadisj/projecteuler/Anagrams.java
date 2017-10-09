package com.hadisj.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 10/3/17.
 */
public class Anagrams {

    List<String> words;
    MathProblems mathProblems = new MathProblems();

    public Anagrams() {
        this.words = mathProblems.readNames("p098_words.txt");
    }

    public int findLargestAnagramSquare() {
        int result = 0;

        //Tag each word with computed value and status
        List<Word> wordsWithValues = computeValues(this.words);
        //Find the anagrams by sorting characters in each word
        wordsWithValues = sortCharsAndTagPairs(wordsWithValues);

        //Find the largest square from the anagram pairs
        for (Word word : wordsWithValues) {
            if (word.siblingInWordPair != null && word.value > result)
                result = word.value;
        }
        return result;
    }

    private List<Word> sortCharsAndTagPairs(List<Word> wordsWithValues) {
        //sort the characters of each word so that we can find anagrams on a second pass
        List<Word> result = new ArrayList<>();

        for (Word word : wordsWithValues) {
            char[] wordCharsSorted = word.word.toCharArray();
            Arrays.sort(wordCharsSorted);
            word.word = new String(wordCharsSorted);
            result.add(word);
        }

        //find the anagrams
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                String currentWordStr = result.get(i).word;
                String nextWordStr = result.get(i+1).word;
                //If these are siblings, mark accordingly
                if (currentWordStr.equals(nextWordStr)) {
                    result.get(i).siblingInWordPair = result.get(i+1);
                    result.get(i+1).siblingInWordPair = result.get(i);
                }
            }
        }

        return result;
    }

    private List<Word> computeValues(List<String> words) {
        List<Word> result = new ArrayList<>();
        for (String word : words) {
            Word theWord = new Word();
            theWord.word = word;
            int value = mathProblems.getNameValue(word);
            theWord.value = value;
            //check if value is a square of something
            if (isSquare(value))
                theWord.isSquareValue = true;
            result.add(theWord);
        }

        return result;
    }

    private boolean isSquare(int value) {
        boolean result = false;
        double sqrRoot = Math.sqrt((double)value);

        //if there isn't anything after the decimal place, then this is a square
        String sqrRootStr = String.valueOf(sqrRoot);
        String[] sqrRootParts = sqrRootStr.split("\\.");

        if (sqrRootParts.length > 1 && sqrRootParts[1].equals("0"))
            result = true;

        return result;
    }

    class Word {
        String word;
        int value;
        boolean isSquareValue;
        Word siblingInWordPair = null;
    }

    public static void main(String[] args) {
        Anagrams app = new Anagrams();
        System.out.println("Largest squared anagram is: " + app.findLargestAnagramSquare());

//        System.out.println(app.isSquare(4));
//        System.out.println(app.isSquare(5));
    }


}
