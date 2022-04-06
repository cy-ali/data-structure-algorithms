package jd2.int_prep;

import java.util.Arrays;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public class Q2_ProductOfArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 4, 2};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

//        Stack<Integer> reverseProduct = new Stack<>();

        Deque<Integer> reverseProduct = new LinkedList<>();

        reverseProduct.push(nums[nums.length - 1]);

        int product = 1;

        for (int i = nums.length - 2; i > 0; i--) {
            reverseProduct.push(nums[i] * reverseProduct.peek());
        }

        for (int i = 0; !reverseProduct.isEmpty(); i++) {

            result[i] = reverseProduct.pop() * product;
            product *= nums[i];

        }
        result[result.length - 1] = product;
        return result;
    }


    public static int[] productExceptSelf2(int[] nums) {

        int[] result = new int[nums.length];
        int product = 1;
        result[0] = product;
        for (int i = 1; i < result.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }

        return result;
    }

}
