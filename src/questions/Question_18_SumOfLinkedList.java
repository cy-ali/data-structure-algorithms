package questions;

import day2_linkedList.MyLinkedList;

public class Question_18_SumOfLinkedList {

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(7);
        list1.addLast(1);
        list2.addLast(9);
        list2.addLast(4);
        list2.addLast(5);
        list1.print();
        list2.print();
        list1.sumLists(list1, list2).print();
    }


}


