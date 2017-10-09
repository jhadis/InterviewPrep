package com.hadisj.crackinginterview.trees;

/**
 * Created by admin on 9/4/17.
 */
/**
 *   Java Program to Implement Hash Trie
 **/

import java.io.*;
import java.util.*;

class HashTrie
{
    private HashMap<Character, HashMap> root;

    /** Constructor **/
    public HashTrie()
    {
        root = new HashMap<Character, HashMap>();
    }
    /** Parameterised Constructor **/
    public HashTrie(String[] arr)
    {
        root = new HashMap<Character, HashMap>();
        for (String s: arr)
            add(s);
    }

    /** Function to add a string to hash trie **/
    public void add(String str)
    {
        HashMap<Character, HashMap> node = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (node.containsKey(str.charAt(i)))
                node = node.get(str.charAt(i));
            else
            {
                node.put(str.charAt(i), new HashMap<Character, HashMap>());
                node = node.get(str.charAt(i));
            }
        }
        /** end of string **/
        node.put('\0', new HashMap<Character, HashMap>(0));
    }

    /** Function to check if hash trie contains a given word **/
    public boolean contains(String str)
    {
        HashMap<Character, HashMap> currentNode = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (currentNode.containsKey(str.charAt(i)))
                currentNode = currentNode.get(str.charAt(i));
            else
                return false;
        }
        return currentNode.containsKey('\0') ? true : false;
    }

    /**
     * Find all words in trie that start with the provided substring
     * @param substring search term
     * @return
     */
    public List<String> findMatchingWords(String substring) {
        List<String> matches = new ArrayList<>();
        HashMap<Character, HashMap> currentNode = root;
        for (int i = 0; i < substring.length(); i++)
        {
            if (currentNode.containsKey(substring.charAt(i)))
                currentNode = currentNode.get(substring.charAt(i));
            else
                return matches;
        }

        if (currentNode.containsKey('\0'))
            matches.add(substring);


//        StringBuilder words = new StringBuilder();
        String currentWord = "";
        traverseTrie(currentNode, matches, currentWord, substring);
        return matches;
    }

    public HashMap<Character, HashMap> traverseTrie(HashMap<Character, HashMap> currentNode, List<String> words, String currentWord,
                                                    String searchSubstring) {
        if (currentNode == null)
            return null;

        if (currentNode.containsKey('\0')) {
            currentWord = searchSubstring + currentWord;
            words.add(currentWord);
            currentWord = "";
            return currentNode;
        }

        for (Character c : currentNode.keySet()) {
            currentWord += c.toString();
            currentNode = currentNode.get(c);
            if (currentNode != null)
                traverseTrie(currentNode, words, currentWord, searchSubstring);
//            for (HashMap<Character, HashMap> currentNodeMap : currentNode.values()) {
//                traverseTrie(currentNodeMap, words, currentWord, searchSubstring);
//            }
        }

        return currentNode;
    }
}