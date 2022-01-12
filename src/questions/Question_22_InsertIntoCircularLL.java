package questions;

public class Question_22_InsertIntoCircularLL {

    public static void main(String[] args) {
        CircularListNode node = new CircularListNode();
//        node.add(4);
//        node.add(5);
//        node.add(6);
//        node.add(7);
//        node.add(1);
//        node.add(2);
        node.add(3);
        node.add(3);
        node.add(3);
        insertVal(node, 0);
        node.print();
    }

    public static CircularListNode insertVal(CircularListNode head, Integer value) {
        CircularListNode nodeToInsert = new CircularListNode();
        nodeToInsert.add(value);

        if (head == null) {
            return nodeToInsert;
        } else if (head.next == null) {
            head.next = nodeToInsert;
            nodeToInsert.next = head;
            return head;
        }

        CircularListNode current = head;
        CircularListNode highestNode = head;

        do {
            if (value >= current.val && value <= current.next.val) {
                nodeToInsert.next = current.next;
                current.next = nodeToInsert;
                break;
            } else {
                if (current.val >= highestNode.val) {
                    highestNode = current;
                }
                current = current.next;
            }
        } while (current != head);

        if (nodeToInsert.next == null) {
            nodeToInsert.next = highestNode.next;
            highestNode.next = nodeToInsert;
        }

        return new CircularListNode();
    }
}

class CircularListNode {
    int val;
    CircularListNode next;
    CircularListNode head;

    CircularListNode() {
    }

    public void add(int val) {
        var nodeToAdd = new CircularListNode();
        nodeToAdd.val = val;
        CircularListNode current = this;

        if (head == null) {
            this.val = val;
            head = this;
            return;
        } else if (head.next == null) {
            this.next = nodeToAdd;
            nodeToAdd.next = current.head;
            return;
        }
        while (current.next != head) {
            current = current.next;
        }
        nodeToAdd.next = head;
        current.next = nodeToAdd;
    }

    public void print() {
        CircularListNode current = this;
        if (head == null) {
            System.out.println("[]");
            return;
        } else if (head.next == null) {
            System.out.println(current.val);
            return;
        }

        current = head;
        while (current.next != head) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println(current.val);
    }
}


