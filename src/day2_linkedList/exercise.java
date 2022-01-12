package day2_linkedList;

public class exercise {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.print();
        list.insertInOrder(55);
//        System.out.println("list.first.value = " + list.first.value);
//        System.out.println("list.last.value = " + list.last.value);
        list.print();
        list.deleteLast();

//        list.reverse();
        list.print();
//        System.out.println(list.getNthLastElement(1));
//        list.printMiddle();
    }


}
