package questions;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Question_25_BasicCalculator {

    public static void main(String[] args) {
        String s = "122";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> primaryOpStack = new Stack<>();
        Stack<Character> secondaryOpStack = new Stack<>();
        int actualNum = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                continue;
            }

            if (Character.isDigit(s.charAt(i))) {
                do {
                    actualNum = actualNum * 10 + (s.charAt(i) - '0');
                    i++;
                }
                while (i < s.length() && Character.isDigit(s.charAt(i)));
                i--;

                if (!primaryOpStack.empty()) {
                    switch (primaryOpStack.peek()) {
                        case '*':
                            actualNum = numStack.pop() * actualNum;
                            break;
                        case '/':
                            actualNum = numStack.pop() / actualNum;
                    }
                    primaryOpStack.pop();
                }
                numStack.push(actualNum);
                actualNum = 0;

            } else if (isPrimaryOp(s.charAt(i))) {
                primaryOpStack.push(s.charAt(i));
            } else {
                secondaryOpStack.push(s.charAt(i));
            }
        }

        Stack<Integer> numStack1 = new Stack<>();
        Stack<Character> secondaryOpStack1 = new Stack<>();
        while (!numStack.empty()) {
            numStack1.push(numStack.pop());
        }
        while (!secondaryOpStack.empty()) {
            secondaryOpStack1.push(secondaryOpStack.pop());
        }

        while (!secondaryOpStack1.empty()) {
            switch (secondaryOpStack1.peek()) {
                case '+':
                    actualNum = numStack1.pop() + numStack1.pop();
                    break;
                case '-':
                    actualNum = numStack1.pop();
                    actualNum -= numStack1.pop();
            }
            numStack1.add(actualNum);
            secondaryOpStack1.pop();
        }
        return numStack1.pop();
    }

    private static boolean isPrimaryOp(char charAt) {
        return charAt == '*' || charAt == '/';
    }
}
