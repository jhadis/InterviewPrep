package com.hadisj.hackerrank.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Jonathan on 4/27/2016.
 * See the problem here: https://www.hackerrank.com/challenges/maximum-element
 *
 * Sample input:
 10
 1 97
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3
 Sample output:
 26
 91
 */
public class StackMaximumElement {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int numQueries = s.nextInt();
        int maxVal = Integer.MIN_VALUE;

        Deque<StackNode> stack = new ArrayDeque<StackNode>();

        for (int i = 0; i < numQueries; i++) {
            int cmd = s.nextInt();
            if (cmd == 1) {
                int val = s.nextInt();
                maxVal = Math.max(maxVal, val);
                StackNode snode = new StackNode(val, maxVal);
                stack.addFirst(snode);
            } else if (cmd == 2) {
                stack.removeFirst();
                if (stack.isEmpty())
                    maxVal = Integer.MIN_VALUE;
                else
                    maxVal = stack.peek().curMax;
            } else if (cmd == 3 && stack.size() > 0) {
                System.out.println(maxVal);
            }
        }

        s.close();
    }
}

class StackNode {
    int val;
    int curMax;

    StackNode(int val, int max) {
        this.val = val;
        this.curMax = max;
    }
}
