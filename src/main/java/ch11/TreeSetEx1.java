package ch11;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("car");
        set.add("dance");
        set.add("elephant");

        System.out.println(set);
        System.out.println(set.subSet(from, to));
        System.out.println(set.subSet(from, to));

    }
}
