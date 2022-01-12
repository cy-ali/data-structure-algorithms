package day6_sorting;

import java.util.Arrays;

public class SortingMainApp {
    public static void main(String[] args) {
        var myArray = new int[]{8, 2, 4, 1, 3};
//        var myBubbleSort = MyBubbleSort.bubbleSort(myArray);
        MyMergeSort.mergeSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
