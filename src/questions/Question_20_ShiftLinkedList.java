package questions;

import day2_linkedList.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question_20_ShiftLinkedList {

    static class LinkedList {
        Integer value;
        LinkedList next;

        LinkedList(Integer value) {
            this.value = value;
            this.next = null;
        }

        LinkedList() {
            this.value = null;
            this.next = null;
        }

        public void addLast(int value) {
            LinkedList node = new LinkedList(value);
            if (this.value == null) this.value = value;

            LinkedList temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        public void print() {
            while (this.value == null) {
                System.out.print(this.value + ", ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();
        list1.addLast(0);
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        list1.addLast(50);
        list1.print();
        MyLinkedList.shift(list1, -2);
        list1.print();
    }


    public LinkedList shift(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList newTail = head;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                head = head.next;
            }

            while (head.next != null) {
                head = head.next;
                newTail = newTail.next;
            }

        } else if (k < 0) {
            for (int i = -1; i > k; i--) {
                newTail = newTail.next;
                head = head.next;
            }

            while (head.next != null) {
                head = head.next;
            }
        } else {
            return head;
        }
        head.next = first;
        first = newTail.next;
        newTail.next = null;
        return first;
    }

}
