package questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Questions_29_BreadthFirstTraversalOfBinaryTree_LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
//        TreeNode treeNode8 = new TreeNode(8);
//        TreeNode treeNode9 = new TreeNode(9);
//        TreeNode treeNode4 = new TreeNode(4, treeNode8, treeNode9);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
//        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        printLevelOrder(null);
    }

    public static void printLevelOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        printLevelOrder(treeNode, queue);
    }

    private static void printLevelOrder(TreeNode treeNode, Queue<TreeNode> queue) {
        System.out.print(treeNode.val + ", ");
        if (treeNode.left != null) queue.add(treeNode.left);
        if (treeNode.right != null) queue.add(treeNode.right);
        while (!queue.isEmpty()) printLevelOrder(queue.poll(), queue);
    }
}
