package jd2.binary_search_tree;

public class repeats {
    public static void main(String[] args) {
        System.out.println(repeatCount("indivisibility"));
    }

    public static int repeatCount(String str) {

        int[] indexes = new int[100];
        int count = 0;
        for (char eachChar : str.toLowerCase().toCharArray()) {
            indexes[eachChar - 48]++;
            if (indexes[eachChar - 48] == 2) {
                count++;
            }
        }
        return count;
    }
}
