package jd2.binary_search_tree;

public class ExesOhs {

    public static void main(String[] args) {

    }

    private static boolean findXOAmount(String str) {

        int amount_O = 0;
        int amount_X = 0;


        for (char eachChar : str.toLowerCase().toCharArray()) {
            if (eachChar == 'o') amount_O++;
            else if (eachChar == 'x') amount_X++;
        }

        return amount_O == amount_X;
    }

}
