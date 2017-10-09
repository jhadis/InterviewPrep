package com.hadisj.crackinginterview.codingbat;

/**
 * Created by Jonathan on 4/15/2016.
 */
public class FizzBuzz {

    /**
     * If input string starts with "f", return "Fizz".  If it ends with "b", return "Buzz".  If
     * it meets both conditions, then return "FizzBuzz"
     * @param str
     * @return
     */
    public String fizzString(String str) {
        String result = str;
        if (str.charAt(0) == 'f') {
            str = "Fizz";
            if (str.charAt(str.length()-1) == 'b') {
                str = str + "Buzz";
            }
        } else if (str.charAt(str.length()-1) == 'b')
            str = "Buzz";

        return str;
    }

    /**
     * Take input integer and return String version of number followed by "!".  If number is divisible by
     * 3, then return "Fizz!".  If it's divisible by 5, return "Buzz!".  If divisible by both 3 and 5,
     * return "FizzBuzz!".
     * @param n
     * @return
     */
    public String fizzString2(int n) {
        String result = String.valueOf(n);
        if (n % 3 == 0) {
            result = "Fizz";
            if (n % 5 == 0) {
                result += "Buzz";
            }
        } else if (n % 5 == 0) {
            result = "Buzz";
        }

        result += "!";
        return result;
    }

    public static void main(String... args) {
        FizzBuzz prog = new FizzBuzz();
        String fizzStringInput = "fib";
        System.out.println("fizzString - input: "
                +fizzStringInput+ " -> " +prog.fizzString(fizzStringInput));
    }
}
