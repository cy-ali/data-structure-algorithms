package jd2.int_prep;

import java.util.HashMap;
import java.util.Map;

public class Q1_Generate_Document {

    public static void main(String[] args) {
        System.out.println(generateDocument2("!veDJaCyd vaeo perlo xw", "Cydeo Java Developer!"));
    }

    public static Boolean generateDocument(String characters, String document) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : characters.toCharArray()) {
            int count = charMap.getOrDefault(c, 0);
            charMap.put(c, count + 1);
        }

        for (char c : document.toCharArray()) {
            int count = charMap.getOrDefault(c, 0);
            if (count < 1) return false;
            charMap.put(c, count - 1);
        }
        return true;
    }

    public static Boolean generateDocument2(String characters, String document) {

        int[] charArr = new int[127];
        for (char c : characters.toCharArray()) {
            charArr[c]++;
        }
        for (char c : document.toCharArray()) {
            if (charArr[c] < 1) {
                return false;
            }
            charArr[c]--;
        }
        return true;
    }

}
