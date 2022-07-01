package jd2.binary_search_tree;

public class allPairs {
    public static void main(String[] args) {

        int[] arr = {};
        System.out.println(countPairs(arr));
    }

    private static int countPairs(int[] arr) {
        int pairs = 0;
        int[] numIndex = new int[1000];

        for (int eachNum : arr) {
            numIndex[eachNum]++;

            if (numIndex[eachNum] == 2) {
                pairs++;
                numIndex[eachNum] = 0;
            }

        }

        return pairs;
    }
}
