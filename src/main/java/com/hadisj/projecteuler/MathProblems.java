package com.hadisj.projecteuler;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by admin on 9/28/17.
 */
public class MathProblems {

    /**
     * Find the smallest number that's a multiple of all the numbers from begin to end (inclusive).
     * @param begin start of the range
     * @param end end of the range
     */
    public static int smallestMultiple(int begin, int end) {
        int answer = 0;
        boolean foundAnswer = false;
        for (int i = begin; i <= Integer.MAX_VALUE; i++) {
            int potentialMultiple = 20 * i;
            for (int j = begin; j <= end * end; j++) {
                if (potentialMultiple % j != 0) {
                    break;
                }
                if (j == end) {
                    answer = potentialMultiple;
                    foundAnswer = true;
                }
            }
            if (foundAnswer)
                break;
        }

        return answer;
    }

    /**
     * Converts a number (up to 1000) to English
     * @param input any int from 1 to 1000
     * @return English representation
     */
    public static String convertIntToWord(int input) {
        if (input > 1000)
            return "Invalid input: number must be 1 to 1000";

        //Determine number of digits
        int counter = 1;
        int tmp = input;
        while (tmp / 10 > 0) {
            tmp = tmp / 10;
            counter++;
        }

        System.out.println("number of digits: " +counter);

        StringBuilder str = new StringBuilder();
        Map<Integer, String> numStrings = new HashMap<>();
        numStrings.put(1, "one");
        numStrings.put(2, "two");
        numStrings.put(3, "three");
        numStrings.put(4, "four");
        numStrings.put(5, "five");
        numStrings.put(6, "six");
        numStrings.put(7, "seven");
        numStrings.put(8, "eight");
        numStrings.put(9, "nine");
        numStrings.put(10, "ten");
        numStrings.put(11, "eleven");
        numStrings.put(12, "twelve");
        numStrings.put(13, "thirteen");
        numStrings.put(14, "fourteen");
        numStrings.put(15, "fifteen");
        numStrings.put(16, "sixteen");
        numStrings.put(17, "seventeen");
        numStrings.put(18, "eighteen");
        numStrings.put(19, "nineteen");
        numStrings.put(20, "twenty");
        numStrings.put(30, "thirty");
        numStrings.put(40, "forty");
        numStrings.put(50, "fifty");
        numStrings.put(60, "sixty");
        numStrings.put(70, "seventy");
        numStrings.put(80, "eighty");
        numStrings.put(90, "ninety");

        if (counter == 1) {
            str.append(numStrings.get(input));
        } else if (counter == 2) {
            str.append(numStrings.get(input));
        } else if (counter == 3) {
            int divisor= counter;
            int tmp2 = input / 100;
            str.append(numStrings.get(tmp));
            str.append("-hundred and");
            while (tmp2 / 10 > 0) {
                tmp2 = tmp2 / 10;
                counter++;
            }
        } else if (counter == 4) {

        }
        return str.toString();
    }

    /** How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)??
     *
     * @return Number of Sundays that fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
     */
    public static int problem19_countingSundays() {
        //1 Jan 1900 was a Monday, so first Sunday was 7 Jan 1900
        int counter = 0;
        int monthsPerYear = 12;
        int daysPerStandardYear = 365;
        int daysPerLeapYear = 366; //Feb. has 29 instead of 28 days
        int monthsPerCentury = monthsPerYear * (2000 - 1901);

        int weeksin1900 = daysPerStandardYear / 7;

        int year = 1900;
        int dayCounter = 0;
        int dayPerMonthCounter = 1;
        int month = 1;

        while (year < 2001) {
            dayCounter++;
            //check if this is a Sunday
            if (dayCounter % 7 == 0) {
                //make sure this is on or after 1/1/1901
                if (year >= 1901 && dayPerMonthCounter == 1)
                    counter++;
            }

            //check if this is the beginning of the month
            if ((month == 1 || month == 3 || month == 5 ||
                    month == 7 || month == 8 || month == 10 ||
                    month == 12) && dayPerMonthCounter == 31) {
                //reset the dayPerMonthCounter and advance the month
                dayPerMonthCounter = 1;
                if (month == 12) {
                    month = 1;
                    year++;
                }
                else
                    month++;
            } else if (month == 2 && dayPerMonthCounter >= 28) {
                //check if leap year.  if not, then reset the
                // dayPerMonthCounter and advance the month
                if ((year % 4 == 0 || year == 2000) && dayPerMonthCounter == 28) {
                    dayPerMonthCounter++;
                } else if ((year % 4 == 0 || year == 2000) && dayPerMonthCounter == 29) {
                    dayPerMonthCounter = 1;
                    month++;
                } else {
                    dayPerMonthCounter = 1;
                    month++;
                }
            } else if ((month == 9 || month == 4 || month == 6 || month == 11) && dayPerMonthCounter == 30) {
                dayPerMonthCounter = 1;
                month++;
            } else {
                dayPerMonthCounter++;
            }
        }
        return counter;
    }

    public int problem22_namesScores() {
        //Read in the contents of the file and
        // populate a list with the names
        List<String> namesList = readNames("p022_names.txt");
        // Sort the list
        Collections.sort(namesList);

        //Calculate the names score per item in list and add to aggregate score
        int aggScore = 0;
        for (int counter = 1; counter <= namesList.size(); counter++) {
            int currScore = getNameValue(namesList.get(counter - 1)) * counter;
            aggScore = aggScore + currScore;
        }
        return aggScore;
    }

    protected int getNameValue(String name) {
        int value = 0;
        int baseLineA = 'A';

        for (Character ch : name.toCharArray()) {
            value = value + (ch - baseLineA + 1);
        }

        return value;
    }

    /**
     * Parse names from file and populate in list
     * @param fileName
     * @return
     */
    protected List<String> readNames(String fileName) {
        List<String> names = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner scanner = new Scanner(classLoader.getResourceAsStream(fileName)).useDelimiter(",");
        while (scanner.hasNext()) {
            String name = scanner.next();
            //trim the quotes
            name = name.replace('"',' ').trim();
            names.add(name);
        }
        scanner.close();
        return names;
    }

    /** The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

     Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
     **/
    public static String problem48_selfPowers() {
        String result = "";
        BigInteger counter = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            //counter.add(Math.pow(i, i));
            BigInteger current = BigInteger.valueOf(i);
            counter = counter.add(current.pow(i));
        }

        //get last 10 digits
        result = counter.toString();
        result = result.substring(result.length() - 10);

        return result;
    }

    /**
     * Find denominator in fraction 1/d where d is between 1 and 1000 that produces the longest
     * repeating number in decimal form.  E.G. 1/3 = .3 repeating where d is between 1 and 5.
     * @return
     */
    public static int problem26_reciprocalCycles() {
        //Find largest prime below 1000
        boolean foundPrime = true;
        int startPoint = 999;
        while (true) {
            if (isPrime(startPoint))
                break;
            startPoint--;
        }

        return startPoint;
    }

    private static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Smallest multiple of numbers from 1 to 20: " + MathProblems.smallestMultiple(1, 20));

//        MathProblems.convertIntToWord(1);
        System.out.println("Number of Sundays in 20th Century: " +MathProblems.problem19_countingSundays());

        MathProblems app = new MathProblems();
        System.out.println("Aggregate score of names in file: " +app.problem22_namesScores());

        System.out.println("Problem 48 - Self Powers; last 10 digits: " +MathProblems.problem48_selfPowers());

        System.out.println("Problem 26 - Reciprocal Cycles; longest cycle when denominator below 1000: "
                +MathProblems.problem26_reciprocalCycles());
    }
}
