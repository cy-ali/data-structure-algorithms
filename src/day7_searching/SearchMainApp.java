package day7_searching;

public class SearchMainApp {
    public static void main(String[] args) {
        int[] myarray = new int[]{1, 2, 3, 4, 5, 6, 89, 100, 110, 111, 112};


        System.out.println("Linear Search : " + MyLinearSearch.linearSearch(myarray, 112));

        System.out.println("Rec Bin Search : " + MyBinarySearchRec.binarySearchRec(myarray, 112));

        System.out.println("Ite Bin Search : " + MyBinarySearchIterative.binSearchIterative(myarray, 112));

        System.out.println("Ternary Search : " + MyTernarySearch.ternarySearch(myarray, 112));

        System.out.println("Jump Search : " + MyJumpSearch.jumpSearch(myarray, 11));
        System.out.println("Expo Search : " + MyExponentialSearch.exponentialSearch(myarray, 11));
    }
}
