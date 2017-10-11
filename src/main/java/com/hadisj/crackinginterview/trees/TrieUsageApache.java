package com.hadisj.crackinginterview.trees;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 10/4/17.
 */


public class TrieUsageApache {

    Trie<String, String> theTrie = new PatriciaTrie<>();

    public void saveWord(String theWord) {
        theTrie.put(theWord, theWord);
    }

    public List<String> findWordsByWildcard(String prefix) {
        List<String> result = new ArrayList();
        Map<String, String> resultMap = theTrie.prefixMap(prefix);
        resultMap.forEach((k, v) -> result.add(v));
        return result;
    }

    public String deleteWord(String theWord) {
        return theTrie.remove(theWord);
    }

    public static void main(String[] args) {
        TrieUsageApache app = new TrieUsageApache();
        app.saveWord("hello");
        app.saveWord("hello my name is");
        app.saveWord("hello my name is Jon");
        app.saveWord("it was a long and winding road");
        app.saveWord("it was a great meal");
        app.saveWord("for it was going to succeed");
        app.saveWord("for it to succeed");

        List<String> hello = app.findWordsByWildcard("hello");
        System.out.println(hello);

        List<String> helloMy = app.findWordsByWildcard("hello my");
        System.out.println(helloMy);

        List<String> it = app.findWordsByWildcard("it");
        System.out.println(it);

        List<String> itWas = app.findWordsByWildcard("it was");
        System.out.println(itWas);

        List<String> itTo = app.findWordsByWildcard("it to");
        System.out.println(itTo);
    }
}
