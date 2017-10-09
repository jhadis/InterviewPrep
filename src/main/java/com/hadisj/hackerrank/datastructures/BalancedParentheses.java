package com.hadisj.hackerrank.datastructures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jonathan on 4/27/2016.
 * Partial solution to this Hackerrank problem: https://www.hackerrank.com/challenges/balanced-parentheses?h_r=next-challenge&h_v=zen
 * Problem statement: taken an input string with the following open characters and make sure that
 * the closing characters are contained in there in reverse order.
 * Input: (([]))
 * Output: YES
 * Input: ([)]
 * Output: NO
 *
 * Sample input:
 3
 {[()]}
 {[(])}
 {{[[(())]]}}

 Sample output:
 YES
 NO
 YES
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        for (int i = 0; i < lines; i++) {
            String str = s.next();
            int chars = str.length();
            boolean matched = true;
            boolean closingMode = false;

            Stack<Character> st = new Stack<Character>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c == '{' || c == '(' || c == '[') {
                    if (closingMode) {
                        matched = false;
                        break;
                    } else
                        st.push(c);
                } else if (c == '}') {
                    closingMode = true;
                    if (st.isEmpty()) {
                        matched = false;
                        break;
                    } else if (st.peek() != '{') {
                        matched = false;
                        break;
                    } else
                        st.pop();

                } else if (c == ')') {
                    closingMode = true;
                    if (st.isEmpty()) {
                        matched = false;
                        break;
                    } else if (st.peek() != '(') {
                        matched = false;
                        break;
                    } else
                        st.pop();

                } else if (c == ']') {
                    closingMode = true;
                    if (st.isEmpty()) {
                        matched = false;
                        break;
                    } else if (st.peek() != '[') {
                        matched = false;
                        break;
                    } else
                        st.pop();
                }
            }
            if (matched)
                System.out.println("YES");
            else
                System.out.println("NO");

        }

        s.close();
    }
}
