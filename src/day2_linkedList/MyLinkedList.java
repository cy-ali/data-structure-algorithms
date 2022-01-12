package day2_linkedList;

import questions.Question_20_ShiftLinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLinkedList {

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    public int size;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertInOrder(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else if (item <= first.value) {
            node.next = first;
            first = node;
        } else {
            Node current = first;
            while (current.next != null && item > current.next.value) {
                current = current.next;
            }
            if (current.next == null) {
                current.next = node;
                last = node;
            } else {
                node.next = current.next;
                current.next = node;
            }
        }
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
        } else {
            Node previous = first;
            Node current = first;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public void print() {
        if (isEmpty()) System.out.println("[]");
        else {
            Node current = first;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }


    //1- reversing the nodes of a singly linked lists in one pass.
    public void reverse() {

        if (first != last) {
            Node current = first;
            Node previous = first;
            Node oneBefore = first;
            while (current.next != null) {
                previous = current;
                current = current.next;
                previous.next = oneBefore;
                oneBefore = previous;
            }
            first.next = null;
            last = first;
            first = current;
            first.next = previous;
        }
    }


    //2- Finding the Kth node from the end in one pass where you don’t know the size of the list.
    public Object getNthLastElement(int nthElement) {
        Node target = first;
        Node current = first;

        for (int i = 1; i < nthElement; i++) {
            current = current.next;
        }

        while (current.next != null) {
            current = current.next;
            target = target.next;
        }
        return target.value;
    }


    //3- Find the middle of a linked list in one pass. If the list has an even number
    //of nodes, there would be two middle nodes. (Note: Assume that you don’t
    //know the size of the list ahead of time.)
    public void printMiddle() {
        Node current = first;
        boolean isEven = false;
        Node midNode = first;
        int[] result = new int[]{midNode.value};

        while (current != last) {
            if (isEven) {
                result = new int[]{midNode.value};
            } else {
                result = new int[]{midNode.value, midNode.next.value};
                midNode = midNode.next;
            }
            isEven = !isEven;
            current = current.next;
        }
        System.out.println(Arrays.toString(result));
    }

//    4. Check the singly linked list if it is Palindrome (Without a stack)
//5. Sort the singly linked list of integers in descending order without using any
//    sort algorithm.

    //    Question 18 Sum of Linked Lists
    public MyLinkedList sumLists(MyLinkedList list1, MyLinkedList list2) {
        int totalSum = convertToInt(list1) + convertToInt(list2);
        return insertList(totalSum);
    }

    private int convertToInt(MyLinkedList list) {
        int sum = 0;
        MyLinkedList.Node current = list.first;
        for (int i = 1; current != null; i *= 10) {
            sum += current.value * i;
            current = current.next;
        }
        return sum;
    }

    private MyLinkedList insertList(int sum) {
        MyLinkedList list = new MyLinkedList();
        while (sum != 0) {
            list.addLast(sum % 10);
            sum /= 10;
        }
        return list;
    }

    //Question 19 Merge Two Linked List

    public static MyLinkedList mergeLists(MyLinkedList list1, MyLinkedList list2) {
        Node current1 = list1.first;
        Node current2 = list2.first;
        MyLinkedList mergedList = new MyLinkedList();

        while (current1 != null && current2 != null) {
            if (current1.value <= current2.value) {
                mergedList.addLast(current1.value);
                current1 = current1.next;
            } else {
                mergedList.addLast(current2.value);
                current2 = current2.next;
            }
        }

        if (current1 == null) {
            while (current2 != null) {
                mergedList.addLast(current2.value);
                current2 = current2.next;
            }
        }

        if (current2 == null) {
            while (current1 != null) {
                mergedList.addLast(current1.value);
                current1 = current1.next;
            }
        }

        return mergedList;
    }

    public static void shift(MyLinkedList list, int k) {
        Node current = list.first;
        Node newTail = list.first;

        if (k > 0) {
            for (int i = 0; i < k; i++) {
                current = current.next;
            }

            while (current.next != null) {
                current = current.next;
                newTail = newTail.next;
            }
            current.next = list.first;
            list.first = newTail.next;

            newTail.next = null;
            list.last = newTail;
        } else if (k < 0) {
            for (int i = -1; i > k; i--) {
                newTail = newTail.next;
                current = current.next;
            }
            while (current.next != null) {
                current = current.next;
            }
            current.next = list.first;
            list.first = newTail.next;

            newTail.next = null;
            list.last = newTail;
        }
    }

}
