package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_6_Three_Number_Sum {

    public static void main(String[] args) {
        int[] numbers = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
//        System.out.println("threeNumSum(numbers, targetSum) = " + threeNumSum(numbers, targetSum));
//        System.out.println("threeNumSum2(numbers, targetSum) = " + Arrays.deepToString(threeNumSum2(numbers, targetSum)));
        System.out.println("threeNumSum3(numbers, targetSum) = " + Arrays.deepToString(threeNumSum3(numbers, targetSum)));
    }


    public static ArrayList<ArrayList<Integer>> threeNumSum(int[] nums, int targetSum) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == targetSum) {
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }

    public static int[][] threeNumSum2(int[] nums, int targetSum) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == targetSum) {
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        triplets.add(triplet);
                    }
                }
            }
        }

        if (triplets.size() == 0) {
            return new int[0][0];
        } else {
            int[][] result = new int[triplets.size()][3];
            for (int i = 0; i < result.length; i++) {
                result[i][0] = triplets.get(i).get(0);
                result[i][1] = triplets.get(i).get(1);
                result[i][2] = triplets.get(i).get(2);
            }
            return result;
        }
    }


    public static int[][] threeNumSum3(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int[][] result = new int[0][3];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == targetSum) {
                        int[][] temp = result;
                        result = new int[result.length + 1][3];

                        for (int l = 0; l < result.length - 1; l++) {
                            result[l] = temp[l];
                        }
                        result[temp.length] = new int[]{nums[i], nums[j], nums[k]};
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : 0));
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();             //Temp for holding overlapping intervals
        for (int i = 0; i < intervals.length - 1; i++) {
            //checks whether last element and first element of the intervals overlapping or not
            if (intervals[i][1] >= intervals[i + 1][0]) {
                if (temp.size() == 0) {                     //0 means last intervals was not overlapping
                    temp.addAll(Arrays.asList(intervals[i][0], intervals[i + 1][1]));
                } else {
                    temp.set(1, intervals[i + 1][1]);       //if last intervals was already overlapping, just extend the interval
                }
            } else {                                        //not overlapping.
                if (temp.size() != 0) {
                    result.add(temp);                        //add temp into the result
                    temp = new ArrayList<>();
                    continue;                                  //If we don't use continue, last interval of temp separately added into result
                }
                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));    //Un-overlapping interval added into result
            }
        }
        if (result.get(result.size() - 1).get(1) < intervals[intervals.length - 1][0]) {                                //If last interval is not overlapping, add it into result.
            result.add(Arrays.asList(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]));
        }
        return result;
    }



}