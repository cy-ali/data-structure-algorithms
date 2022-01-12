package questions;

public class Question_10_Reverse_Words {
    public static void main(String[] args) {

        String str = " John          is the best! ";
        reverseString(str);
    }

    public static String reverseString(String str) {
        String result = "";
        String temp = "";

        for (int i = str.length() - 1; i >= 0; ) {

            while (i >= 0 && str.charAt(i) != ' ') {
                temp = str.charAt(i) + temp;
                i--;
            }
            result += temp;
            temp = "";

            while (i >= 0 && str.charAt(i) == ' ') {
                result += " ";
                i--;
            }
        }
        return result;
    }
}
