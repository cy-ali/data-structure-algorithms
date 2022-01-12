package day2_linkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = head.prev = node;
            node.prev = tail;
            node.next = head;
            head = node;
        }
    }

    public void setTail(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = tail.next = node;
            node.prev = tail;
            node.next = head;
            tail = node;
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        boolean isNodeHead = (node == head);

        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;
        node.prev.next = node.prev = nodeToInsert;

        if (isNodeHead) {
            head = nodeToInsert;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        var isNodeTail = (node == tail);
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        node.next.prev = node.next = nodeToInsert;
        if (isNodeTail) {
            tail = nodeToInsert;
        }
    }

    public void insertAfterValue(Node node, int value) {
        Node target = head;
        while (true) {
            if (target.value == value) {
                insertAfter(target, node);
                break;
            } else {
                target = target.next;
                if (target == head) {
                    throw new NoSuchElementException("No such value");
                }
            }
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        int index = 0;
        Node target = head;

        while (true) {
            if (index == position) {
                insertBefore(target, nodeToInsert);
                break;
            } else {
                target = target.next;
                index++;
                if (target == head) {
                    throw new NoSuchElementException("There is not such a position");
                }
            }
        }
    }

    public void removeNodesWithValue(int value) {
        Node target = head;
        while (true) {
            if (target.value == value) {
                remove(target);
                break;
            } else {
                target = target.next;
                if (target == head) {
                    throw new NoSuchElementException("No such value");
                }
            }
        }
    }

    public void remove(Node node) {
        if (node == head) {
            node.next = head;
        } else if (node == tail) {
            node.prev = tail;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int indexOf(int value) {
        int index = 0;
        Node target = head;

        while (true) {
            if (target.value == value) {
                return index;
            } else {
                target = target.next;
                index++;
                if (target == head) {
                    return -1;
                }
            }
        }
    }

    public boolean containsNodeWithValue(int value) {
        Node target = head;
        while (true) {
            if (target.value == value) {
                return true;
            } else {
                target = target.next;
                if (target == head) {
                    return false;
                }
            }
        }
    }

    public void print() {
        Node target = head;
        if (head == null) {
            System.out.print("[]");
        } else {
            while (true) {
                System.out.print(target.value + ", ");
                if (target.next == head) {
                    break;
                }
                target = target.next;
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

// Do not edit the class below.
class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
