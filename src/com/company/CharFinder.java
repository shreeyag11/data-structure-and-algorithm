package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char firstNonRepeatingChar(String s) {

        if(s.length() == 0)
            return 0;

        s = s.toLowerCase();

        Map<Character, Integer> unique = new HashMap<>();

        var chars = s.toCharArray();
        for (var c : chars) {
            unique.put(c, unique.getOrDefault(c, 0) + 1);
        }

        System.out.println(unique);
        for (var c : chars) {
            if(unique.get(c) == 1)
                return c;
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for(Character ch : str.toCharArray()) {
            if(set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
