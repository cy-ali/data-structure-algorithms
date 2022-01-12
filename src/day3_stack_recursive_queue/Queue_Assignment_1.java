package day3_stack_recursive_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_Assignment_1 {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);
        integerQueue.add(8);
        integerQueue.add(9);

        System.out.println("integerQueue = " + integerQueue);
        reverseKElements(integerQueue, 2);

    }

//    1. Given an integer K and a queue of integers, write code to reverse the order of the first K elements of the queue.
//            -Input: Q = [10, 20, 30, 40, 50], K = 4
//            -Output: Q = [40,30, 20, 10,50]

    public static void reverseKElements(Queue<Integer> intQueue, int K) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> result = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            stack.push(intQueue.remove());
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        while (intQueue.peek() != null) {
            result.add(intQueue.remove());
        }
        System.out.println("result = " + result);

    }
}
