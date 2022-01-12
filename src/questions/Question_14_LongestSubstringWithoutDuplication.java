package questions;

public class Question_14_LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        String str = "Write a function that takes in a string and returns abcdefghij its longest substring without duplicate characters. ";
        String str1 = "";
        String str2 = "clem";
        String str3 = "clementisacap";
        String str4 = "123456374.asdfghjklqwerr";
        longestSubStr(str);
        longestSubStr(str1);
        longestSubStr(str2);
        longestSubStr(str3);
        longestSubStr(str4);
    }

    public static void longestSubStr(String str) {
        String substring = "";
        String result = "";

        outer:
        for (int i = 0; i < str.length(); i++) {
            String actualChar = "" + str.charAt(i);
            boolean isLastChar = i == str.length() - 1;

            while (!substring.contains(actualChar)) {
                substring += str.charAt(i);
                if (isLastChar) {
                    break;
                }
                continue outer;
            }

            if (!isLastChar) {
                i = returnToPreviousChar(str, i);
            }

            if (substring.length() > result.length()) {
                result = substring;
            }

            substring = "";
        }

        System.out.println("result = " + result);
    }

    private static int returnToPreviousChar(String str, int i) {
        char targetChar = str.charAt(i);

        while (!(str.charAt(i - 1) == targetChar)) {
            i--;
        }
        return i - 1;
    }

}

