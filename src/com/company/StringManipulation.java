package com.company;


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
}
