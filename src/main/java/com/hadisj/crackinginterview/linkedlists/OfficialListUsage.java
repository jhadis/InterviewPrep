package com.hadisj.crackinginterview.linkedlists;

import java.util.LinkedList;

/**
 * Created by admin on 7/25/17.
 */
public class OfficialListUsage {

    LinkedList<String> list = null;

    public OfficialListUsage() {
        this.list = new LinkedList<>();
    }

    public static void main(String[] args) {
        OfficialListUsage prog = new OfficialListUsage();
        prog.setup();
        prog.print();
    }

    private void setup() {
        list.add("1");
        list.add("2");
        list.add("3");
    }

    private void print() {
        for (String e : list) {
            System.out.println(e);
        }
    }
}
