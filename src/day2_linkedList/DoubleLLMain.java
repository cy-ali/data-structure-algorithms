package day2_linkedList;

public class DoubleLLMain {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        doublyLinkedList.setHead(n3);
        doublyLinkedList.setHead(n2);
        doublyLinkedList.setHead(n1);
        doublyLinkedList.setTail(n4);
        doublyLinkedList.setTail(n6);
        doublyLinkedList.print();
        doublyLinkedList.insertBefore(n6, n5);
        doublyLinkedList.print();
        doublyLinkedList.setTail(n7);
        doublyLinkedList.insertAfter(n7, n8);
        doublyLinkedList.insertAfterValue(n9, 8);
        doublyLinkedList.setTail(n11);
        doublyLinkedList.insertAtPosition(9, n10);
        doublyLinkedList.print();

        System.out.println("containsNodeWithValue(10) = " + doublyLinkedList.containsNodeWithValue(10));
        System.out.println("indexOf(10) = " + doublyLinkedList.indexOf(10));
        System.out.println("indexOf(8) = " + doublyLinkedList.indexOf(8));
        System.out.println("containsNodeWithValue(28) = " + doublyLinkedList.containsNodeWithValue(28));
        doublyLinkedList.remove(n7);
        System.out.println("---After deletion of 7---");
        doublyLinkedList.print();
        doublyLinkedList.removeNodesWithValue(3);
        System.out.println("---After deletion of 3---");
        doublyLinkedList.print();

    }
}
