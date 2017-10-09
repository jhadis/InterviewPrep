package com.hadisj.hackerrank.tutorial;

import java.util.*;

/**
 * Created by admin on 9/6/17.
 */
public class Miscellaneous {

    public static String reverseStringWithList(String input) {
        StringBuilder result = new StringBuilder(input.length());
        List<Character> characterList = new ArrayList<>(input.length());

        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            characterList.add(inputArr[i]);
        }

        Collections.reverse(characterList);
        for (Character c : characterList) {
            result.append(c);
        }

        return result.toString();
    }

    public static String reverseStringWithStack(String input) {
        StringBuilder result = new StringBuilder(input.length());
        Deque<Character> characterStack = new LinkedList<>();

        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            characterStack.push(inputArr[i]);
        }

        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }

        return result.toString();
    }

    public static String reverseStringWithLoop(String input) {
        StringBuilder result = new StringBuilder(input.length());

        char[] inputArr = input.toCharArray();
        for (int i = inputArr.length - 1; i >= 0; i--) {
            result.append(inputArr[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Miscellaneous.reverseStringWithList("MLB"));
        System.out.println(Miscellaneous.reverseStringWithStack("disney"));
        System.out.println(Miscellaneous.reverseStringWithLoop("input"));
    }

}
