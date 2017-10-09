package com.hadisj.crackinginterview.recursion;

/**
 * Created by Jonathan on 4/28/2016.
 */
public class Palindrome {

    boolean isPalindrome(String str, int i) {
        if (str.length() == 1)
            return true;

        int endIndex = str.length() - 1 - i;

        if (str.charAt(i) != str.charAt(endIndex))
            return false;
        else {
            if (endIndex - i == 1 || endIndex == i) {
                return true;
            } else
                return isPalindrome(str, i+1);
        }
    }

    boolean isPalindrome2(String str) {
        if (str.length() == 0 || str.length() == 1)
            return true;

        if (str.charAt(0) != str.charAt(str.length()-1))
            return false;
        else {
            String substr = str.substring(1, str.length() - 1);
            return isPalindrome2(substr);
        }
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String t1 = "abba";
        String t2 = "abea";
        System.out.println(p.isPalindrome(t1, 0));
        System.out.println(p.isPalindrome(t2, 0));

        System.out.println("use substrings for recursion");
        System.out.println(p.isPalindrome2(t1));
        System.out.println(p.isPalindrome2(t2));
    }
}
