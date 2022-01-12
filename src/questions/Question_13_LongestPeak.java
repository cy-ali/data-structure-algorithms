package questions;

import java.util.*;

public class Question_13_LongestPeak {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
//        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};
//        System.out.println(longestPeak(arr));

        int[] arr1 = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};//6
        System.out.println(Arrays.toString(arr1) + " ::: " + longestPeak(arr1));
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};//0
        System.out.println(Arrays.toString(arr2) + " ::: " + longestPeak(arr2));
        int[] arr3 = new int[]{1, 2, 3};//0
        System.out.println(Arrays.toString(arr3) + " ::: " + longestPeak(arr3));
        int[] arr4 = new int[]{3, 3, 3};//0
        System.out.println(Arrays.toString(arr4) + " ::: " + longestPeak(arr4));
        int[] arr5 = new int[]{-3, -13, -23};//0
        System.out.println(Arrays.toString(arr5) + " ::: " + longestPeak(arr5));
        int[] arr6 = new int[]{-3, 3, 1, 2, 3 , -10, -18, 7};//5
        System.out.println(Arrays.toString(arr6) + " ::: " + longestPeak(arr6));
    }

    public static ArrayList<Integer> longestPeak(int[] arr) {
        boolean increasing = false;
        boolean decreasing = false;
        ArrayList<Integer> peak = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            peak.add(arr[i]);

            while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                increasing = true;
                peak.add(arr[i + 1]);
                i++;
            }

            while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                decreasing = true;
                peak.add(arr[i + 1]);
                i++;
            }

            if (increasing && decreasing) {
                if (peak.size() > result.size()) {
                    result = (ArrayList<Integer>) peak.clone();
                }
                i--;
            }

            peak.clear();
            increasing = false;
            decreasing = false;
        }
        return result;
    }

}