package jd2.int_prep;

import java.util.HashMap;
import java.util.Map;

public class Q3_RomanToInt {
    //    Roman To Int

    //    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //    of the two sorted arrays.
    //    The overall run time complexity should be O(log (m+n))

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'I' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
                    result -= 1;
                    continue;
                }
            }

            if (s.charAt(i) == 'X' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                    result -= 10;
                    continue;
                }
            }

            if (s.charAt(i) == 'C' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                    result -= 100;
                    continue;
                }
            }
            result += findValue(s.charAt(i));
        }
        return result;
    }

    private static int findValue(char charAt) {
        Map<Character, Integer> romanValues = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        return romanValues.get(charAt);
    }
}
