package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_8_Merge_Overlapping_Interval {

    public static void main(String[] args) {
        int[][] intervals = {{6, 8}, {1, 2}, {3, 5}, {4, 7}, {9, 10}};
//        int[][] intervals = {{1, 3}, {1, 4}, {1, 5}};
        System.out.println("intervals = " + Arrays.deepToString(intervals));
        System.out.println("mergeOverlappingIntervals(intervals) = " + mergeOverlappingIntervals(intervals));
        System.out.println("intervals = " + Arrays.deepToString(intervals));

    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : 0));                               //Instead of contiguous arrays, I wanted to compare all intervals
//        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[1], o2[1])));
//        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1])));
        List<List<Integer>> result = new ArrayList<>();                                                                 //Empty list for adding intervals
        List<Integer> temp = new ArrayList<>();                                                                         //Temporary list for holding overlapping intervals

        for (int i = 0; i < intervals.length - 1; i++) {
            //checks whether last element and first element of the intervals
            if (intervals[i][1] >= intervals[i + 1][0]) {                                                                                                          //overlapping or not

                if (temp.size() == 0) {                                                                                 //temp==0 means last intervals was not overlapping
                    temp.addAll(Arrays.asList(intervals[i][0], intervals[i + 1][1]));
                } else {
                    temp.set(1, intervals[i + 1][1]);                                                                   //if last intervals was already overlapping, just extend the interval
                }

            } else {                                                                                                    //intervals are not overlapping.

                if (temp.size() != 0) {                                                                                 //if last elements are overlapping, add them into the result
                    result.add(temp);
                    temp = new ArrayList<>();
                    continue;                                                                                           //If we don't use continue, last interval of temp separately added into result
                }

                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));                                            //Un-overlapping interval added into result
            }
        }

        if (result.get(result.size() - 1).get(1) < intervals[intervals.length - 1][0]) {                                //For adding last interval into result. If last interval is not overlapping
            result.add(Arrays.asList(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]));           //added into result.
        }
        return result;
    }
}
