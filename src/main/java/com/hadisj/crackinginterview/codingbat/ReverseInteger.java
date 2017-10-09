package com.hadisj.crackinginterview.codingbat;


import java.util.LinkedList;

/**
 * Created by admin on 7/26/17.
 */
public class ReverseInteger {

    private void reverseInt(int input) {
        LinkedList<Integer> stack = new LinkedList<>();
        int lastDigit = -1;
        while (input > 9) {
            lastDigit = input % 10;
            input = input / 10;
            stack.addLast(lastDigit);
        }
        stack.addLast(input);
        while (!stack.isEmpty()) {
            System.out.print(stack.remove());
        }
    }

    private int reverseInt2(int input) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        int lastDigit = -1;
        while (input > 9) {
            lastDigit = input % 10;
            input = input / 10;
            stack.addLast(lastDigit);
        }
        stack.addLast(input);
        while (!stack.isEmpty()) {
            result = (int)Math.pow(10.0,(double)stack.size()-1) * stack.remove() + result;
        }
        return result;
    }

    private int reverseInt3(int input) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        int lastDigit = -1;
        while (input > 9) {
            lastDigit = input % 10;
            input = input / 10;
            stack.addLast(lastDigit);
        }
        stack.addLast(input);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.remove());
        }
        result = new Integer(sb.toString());
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger prog = new ReverseInteger();
        prog.reverseInt(123);
        System.out.println();
        int answer = prog.reverseInt2(123);
        System.out.println(answer);
        answer = prog.reverseInt3(123);
        System.out.println(answer);
    }
}
