package questions;


import java.util.Stack;

public class Question_21_Palindrome_LinkedList {

    public static void main(String[] args) {
        ListNode nodes = new ListNode();
        nodes.add(5);
        nodes.add(1);
        nodes.add(2);
        nodes.add(10);
        nodes.add(2);
        nodes.add(1);
        nodes.add(5);
        nodes.print();
        System.out.println(isPalindrome(nodes));

    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode pointer = head;
        boolean isOdd = true;
        while (pointer.next != null) {
            if (isOdd) {
                stack.push(head.val);
                pointer = pointer.next;
                head = head.next;
                isOdd = false;

            } else {
                pointer = pointer.next;
                isOdd = true;
            }
        }
        while (head != null) {
            if (isOdd) {
                head = head.next;
                isOdd = false;
            }

            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public void add(int val) {
        var nodeToAdd = new ListNode();
        nodeToAdd.val = val;
        ListNode current = this;
        if (this.val == 0 && this.next == null) {
            this.val = val;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = nodeToAdd;
    }

    public void print() {
        ListNode current = this;
        if (this.val == 0 && this.next == null) {
            System.out.println("[]");
            return;
        }
        while (current.next != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println(current.val);
    }
}
