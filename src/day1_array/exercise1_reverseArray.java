package day1_array;

import java.util.Arrays;

public class exercise1_reverseArray {
//            Assignments
//            1. Reverse order of an array of unordered integers.  (Easy-Warm up.)
//            2. Rotate an (n x n) matrix  90 degrees right in place. (Medium Level)

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(reverseArr(numbers)));
    }

    public static int[] reverseArr(int[] inorderedArr) {
        int[] reversedArr = new int[inorderedArr.length];
        for (int i = 0; i < reversedArr.length; i++) {
            reversedArr[i] = inorderedArr[inorderedArr.length - (i + 1)];
        }
        return reversedArr;
    }

}
