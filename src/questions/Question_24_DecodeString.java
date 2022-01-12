package questions;

import java.util.Stack;

public class Question_24_DecodeString {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(s);
        System.out.println(decode(s));
    }

    public static String decode(String encoded) {

        String result = "";
        String k = "";
        String partialText = "";
        Stack<Character> stack = new Stack<>();
        boolean isInnerEncoded = false;
        int i = 0;

        while (i < encoded.length()) {
            if (Character.isLetter(encoded.charAt(i))) {
                result += "" + encoded.charAt(i);
                i++;
            } else {
                while (encoded.charAt(i) != '[') {
                    k += "" + encoded.charAt(i);
                    i++;
                }
                stack.push('[');
                i++;
                while (!stack.empty()) {
                    if (encoded.charAt(i) == ']') {
                        stack.pop();
                        if (stack.empty()) {
                            i++;
                            continue;
                        }
                    } else if (encoded.charAt(i) == '[') {
                        stack.push('[');
                        isInnerEncoded = true;
                    }
                    partialText += "" + encoded.charAt(i);
                    i++;
                }
                if (isInnerEncoded) {
                    partialText = decode(partialText);
                }
                int times = Integer.parseInt(k);
                for (int j = 0; j < times; j++) {
                    result += partialText;
                }
            }
            partialText = "";
            k="";
        }
        return result;
    }
}
