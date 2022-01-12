package questions;

import java.util.Stack;

public class Question_23_BalancedBrackets {
    public static void main(String[] args) {
        String str = "([])(){}(())()()";
        String str2 = "d(";
        System.out.println(isBalanced(str2));
    }

    public static boolean isBalanced(String givenStr) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < givenStr.length(); i++) {

            if (isOpening(givenStr.charAt(i))) {
                stack.push(givenStr.charAt(i));
            } else if (isClosing(givenStr.charAt(i))) {
                if (stack.empty()) {
                    return false;
                }
                char popped = stack.pop();
                char corresponding = corresponding(givenStr.charAt(i));
                if (!(popped == corresponding)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static boolean isOpening(char character) {
        char[] openingBrackets = {'(', '{', '['};
        return character == openingBrackets[0] || character == openingBrackets[1] || character == openingBrackets[2];
    }

    public static boolean isClosing(char character) {
        char[] closingBrackets = {')', '}', ']'};
        return character == closingBrackets[0] || character == closingBrackets[1] || character == closingBrackets[2];
    }

    public static char corresponding(char character) {
        switch (character) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        throw new IllegalStateException("Wrong input as corresponding");
    }
}



