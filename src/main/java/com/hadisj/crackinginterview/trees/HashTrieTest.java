package com.hadisj.crackinginterview.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 9/4/17.
 */
public class HashTrieTest
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Accept words **/
        System.out.println("Trie Test\n");
        System.out.println ("Enter words (space-separated) to be entered into trie");
        String input = br.readLine();
        String[] s = input.split(" ");
        /** Create Trie with accepted words **/
        HashTrie t = new HashTrie(s);
        /** Trie Test **/
        char ch = 'n';
        do
        {
            System.out.println("\nEnter word to search ");
            String key = br.readLine();
            System.out.println("Search status : "+ t.contains(key));

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = br.readLine().charAt(0);
        } while (ch == 'Y'|| ch == 'y');

        //Find matching words
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
            System.out.println("Enter search term:");
            input = scanner.next();
            List<String> words = t.findMatchingWords(input);
            System.out.println("Matching words: ");
            for (String word : words) {
                System.out.println(word);
            }
            System.out.println("----------------------------");
//        }
        scanner.close();
    }
}