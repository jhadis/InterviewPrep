package com.hadisj.crackinginterview.arraysandstrings;

import java.util.Formatter;

/**
 * Created by Jonathan on 2/15/2016.
 */
public class URLify {

    char[] urlify(char[] input, int strLength) {
        int position = 0;
        int endPosition = strLength-1;

        while (position < endPosition) {
            if (input[position] == ' ') {
                try {
                    transpose(input,position, endPosition,2);
                    input[position] = '%';
                    input[position+1] = '2';
                    input[position+2] = '0';
                    position = position+3;
                    endPosition = endPosition + 2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                position++;
            }

        }
        return input;
    }

    private void transpose(char[] input, int startPosition, int endPosition, int numCharsToAdvance) throws Exception {
        if (endPosition + numCharsToAdvance > input.length-1)
            throw new Exception("Character array isn't big enough to accommodate a string this large.");

        int tempPosition = endPosition;
        for (int i = tempPosition; tempPosition >= startPosition; tempPosition--) {
            input[tempPosition+numCharsToAdvance] = input[tempPosition];
        }

    }

    public static void main(String[] args) {
        URLify test = new URLify();
        String inputString = "abc def ghi j                           ";
        System.out.println("Before: " +inputString);
        char[] input = inputString.toCharArray();
        test.urlify(input,13);
        System.out.println("After: " +String.valueOf(input));

        inputString = "abc    def ghi j                               ";
        System.out.println("Before: " +inputString);
        input = inputString.toCharArray();
        test.urlify(input,16);
        System.out.println("After: " +String.valueOf(input));

    }
}
