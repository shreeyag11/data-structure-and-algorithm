package com.company;


import java.util.*;

public class StringManipulation {

    public static int countVowels(String str) {
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

    public static String reverse(String str) {
        if (str == null)
            return "";

        char[] ch = str.toCharArray();
        int i = 0, j = str.length() - 1;

        while(i < j) {
            swap(i, j, ch);
            i++;
            j--;
        }

        return String.valueOf(ch);
    }

    private static void swap(int first, int second, char[] ch) {
        char temp = ch[first];
        ch[first] = ch[second];
        ch[second] = temp;
    }

    public static String reverseWords(String input) {
        if (input == null)
            return "";

        String[] inputArr = input.split(" ");
        int i = 0, j = inputArr.length - 1;

        while(i < j) {
            swap(i, j, inputArr);
            i++;
            j--;
        }

        return String.join(" ", inputArr);
    }

    private static void swap(int first, int second, String[] arr) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length()) &&
                (str1 + str1).contains(str2);
    }

    public static String removeDuplicates(String input) {
        if (input == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static char findMostRepeatedChar(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();

        HashMap<Character, Integer> count = new HashMap<>();

        for (char ch : input.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0) + 1);

        int max = Integer.MIN_VALUE;
        char result = ' ';
        for (Character ch : count.keySet())
            if (count.get(ch) > max) {
                max = count.get(ch);
                result = ch;
            }

        return result;
    }

    public static String sentenceCapitalization(String input) {
        if (input == null || input.trim().isEmpty())
            return "";

        String[] words = input
                            .trim()
                            .replaceAll(" +", " ")
                            .split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagram(String str1, String str2) {
        if (str1 == null || str2 == null ||
                str1.length() != str2.length())
            return false;

        final int ALPHA_SIZE = 26;
        int[] alpha = new int[ALPHA_SIZE];

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length(); i++) {
            alpha[str1.charAt(i) - 'a']++;
            alpha[str2.charAt(i) - 'a']--;
        }

        for (int i : alpha)
            if (i != 0)
                return false;

            return true;
    }
}
