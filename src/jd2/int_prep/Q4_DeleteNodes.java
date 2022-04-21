package jd2.int_prep;

public class Q4_DeleteNodes {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode node = arrayToListNode(arr);
        print(node);
        System.out.println();
        print(deleteNAfterMNodes(node,2,3));
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    public static ListNode arrayToListNode(int[] arr) {
        ListNode nodeToAdd = new ListNode(arr[0]);
        ListNode head = nodeToAdd;
        for (int i = 1; i < arr.length; i++) {
            nodeToAdd.next = new ListNode(arr[i]);
            nodeToAdd = nodeToAdd.next;
        }
        return head;
    }


    public static ListNode deleteNAfterMNodes(ListNode head, int m, int n) {
        ListNode pointer1 = head;
        ListNode pointer2;

        while (pointer1 != null) {

            for (int i = 0; i < m - 1 && pointer1.next != null; i++) {
                pointer1 = pointer1.next;
            }

            pointer2 = pointer1.next;

            for (int i = 0; i < n && pointer2 != null; i++) {
                pointer2 = pointer2.next;
            }

            pointer1.next = pointer2;
            pointer1 = pointer2;
        }

        return head;
    }
}
