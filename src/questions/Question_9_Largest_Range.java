package questions;

import java.util.*;

public class Question_9_Largest_Range {

    public static void main(String[] args) {
        int[] numbers = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6, 16, -2, 28, 20};
//        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("largestRange(numbers) = " + Arrays.toString(largestRange2(numbers)));
        System.out.println("Sorted Array = " +Arrays.toString(numbers));
    }

    public static int[] largestRange(int[] nums) {
        int[] result = new int[2];
        int range = 0;
        Map<int[], Integer> ranges = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            result[0] = nums[i];
            while (nums.length - 1 != i && nums[i] + 1 == nums[i + 1]) {
                range++;
                i++;
            }
            result[1] = nums[i];
            ranges.put(result.clone(), range);
            range = 0;
        }
        Map.Entry<int[], Integer> maxEntry = ranges.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get();
        return maxEntry.getKey();
    }

    /*
    POINTS TO CONSIDER
    sorting
    how to hold ranges separately and compare them with each other.
                -> map - thread
    how to put pick first element even without changing until range elements end.
                - assign them before while loop which checks next element is 1 more than before
    how to pick last element after range ends
                - after while loop breaks down add second element
    Out of bound exception for bot outer and inner loop
                - For outer it is straight forward, we decrease loop with minus 1
                - since inner is while how do we solve this issue? Because if the last element is one plus to previous, while loop will try to iterate
    Putting into map. If we directly add result into map, result variable is dynamically changes in the map and there will be only one K/V at the end
                -result.clone()

    Instead of lambda --> Comparator.comparing(Map.Entry::getValue)

    Question= It seems O(nxn) but in reality it is O(n). Because while also increases i.
     */

    public static int[] largestRange2(int[] nums) {
        int[] result = new int[2];
        int range = 0;
        Map<int[], Integer> ranges = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            result[0] = nums[i];
            while (nums.length - 1 != i && nums[i] + 1 == nums[i + 1]) {
                range++;
                i++;
            }
            result[1] = nums[i];
            ranges.put(result.clone(), range);
            range = 0;
        }
        ranges.forEach((key, value) -> System.out.println("o1 = " + Arrays.toString(key) + ", " + value));
        Map.Entry<int[], Integer> maxEntry = ranges.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get();
        return maxEntry.getKey();
    }

}
