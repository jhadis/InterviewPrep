package com.hadisj.crackinginterview.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jonathan on 4/18/2016.
 */
public class StringProblems {

    public int isPalindrome(String a) {
        StringBuffer cleanedInput = new StringBuffer();
        a = a.toLowerCase();
        for (char c : a.toCharArray()) {
            if (Character.isLetter(c))
                cleanedInput.append(String.valueOf(c));
        }
        String cleanedInputStr = cleanedInput.toString();
        StringBuffer reversedInput = new StringBuffer();

        StringBuffer sb = new StringBuffer();
        char[] cleanedInputArray = cleanedInputStr.toCharArray();
        for (int i = cleanedInputArray.length - 1; i >= 0; i--) {
            reversedInput.append(String.valueOf(cleanedInputArray[i]));
        }

        if (cleanedInputStr.equals(reversedInput.toString()))
            return 1;
        else return 0;


    }

    public char mostRepeatingLetter(String input) {
        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        char[] inputChars = input.toUpperCase().toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            char key = inputChars[i];
            if (Character.isLetter(key)) {
                letterCountMap.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
//                if (letterCountMap.containsKey(key))
//                    letterCountMap.put(key, letterCountMap.get(key) + 1);
//                else {
//                    letterCountMap.put(key, 1);
//                }
            }

        }

        int mostRepeatingCount = 0;
        Character mostRepeating = null;

        for (Map.Entry<Character, Integer> e : letterCountMap.entrySet()) {
            if (e.getValue() >= mostRepeatingCount) {
                mostRepeating = e.getKey();
                mostRepeatingCount = e.getValue();
            }
        }

        System.out.println("The most repeating character is " +mostRepeating+ " and it occurs " +mostRepeatingCount+ " times.");
        return mostRepeating;
    }

    public static void main(String... args) {
        StringProblems prog = new StringProblems();
        String inputForPalindrome = "A man, a plan, a canal: Panama";
        System.out.println(prog.isPalindrome(inputForPalindrome));

        prog.mostRepeatingLetter(inputForPalindrome);
    }


}
