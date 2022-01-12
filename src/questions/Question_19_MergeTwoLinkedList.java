package questions;

import day2_linkedList.MyLinkedList;

public class Question_19_MergeTwoLinkedList {
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);

        MyLinkedList list2 = new MyLinkedList();
        list2.addLast(-11);
        list2.addLast(3);
        list2.addLast(4);

        printExample(list1, list2);
        MyLinkedList list3 = new MyLinkedList();
        MyLinkedList list4 = new MyLinkedList();
        list4.addLast(5);

        printExample(list3, list4);


    }

    public static void printExample(MyLinkedList list1, MyLinkedList list2) {
        System.out.print("list1: ");
        list1.print();
        System.out.print("list2: ");
        list2.print();
        System.out.print("MERGED LIST : ");
        MyLinkedList.mergeLists(list1, list2).print();

        MyLinkedList list3 = new MyLinkedList();
        MyLinkedList list4 = new MyLinkedList();
    }
}
