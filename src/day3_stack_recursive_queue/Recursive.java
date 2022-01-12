package day3_stack_recursive_queue;

public class Recursive {
    public static void main(String[] args) {
        factorial(5);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
