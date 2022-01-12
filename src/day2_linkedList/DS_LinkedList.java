package day2_linkedList;

import java.util.NoSuchElementException;

public class DS_LinkedList {
    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    public int size;

    public DS_LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        System.out.println("adding an item: " + item);
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
        System.out.println("deleting an item from the last: ");
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

    public void printLinkedList() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node current = first;
            while (current != null) {
                System.out.println("Value: " + current.value);
                current = current.next;
            }
        }

    }
}

