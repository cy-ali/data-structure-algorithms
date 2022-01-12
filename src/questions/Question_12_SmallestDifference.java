package questions;

import java.util.Arrays;

public class Question_12_SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        smallestDifference(arrayOne, arrayTwo);
    }

    public static void smallestDifference(int[] nums1, int[] nums2) {
        int difference = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                int actualDifference = Math.abs(nums1[i] - nums2[j]);

                if (actualDifference < difference) {
                    result[0] = nums1[i];
                    result[1] = nums2[j];
                    difference = actualDifference;
                }
            }
        }
        System.out.println("result = " + Arrays.toString(result));
    }
}
