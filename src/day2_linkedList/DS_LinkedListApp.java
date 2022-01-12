package day2_linkedList;

public class DS_LinkedListApp {
    public static void main(String[] args) {
        DS_LinkedList list = new DS_LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.printLinkedList();
        list.deleteLast();
        list.printLinkedList();
    }
}
