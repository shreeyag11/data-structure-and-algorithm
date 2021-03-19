package com.company;

public class StringManipulation {

    public int countVowels(String str) {
        if (str == null)
            return 0;

        String vowels = "aeiou";
        int count = 0;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1)
                count++;
        }

        return count;
    }
}
