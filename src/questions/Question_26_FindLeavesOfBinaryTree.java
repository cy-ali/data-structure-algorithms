package questions;

import java.util.ArrayList;
import java.util.List;

public class Question_26_FindLeavesOfBinaryTree {

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
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        System.out.println(findAllLeaves(treeNode1, new ArrayList<List<Integer>>()));
    }


    public static List<List<Integer>> findAllLeaves(TreeNode treeNode, List<List<Integer>> finalArr) {

        List<Integer> arr = new ArrayList<>();
        finalArr.add(getLeavesArr(treeNode, arr));
        deleteLeaves(treeNode);
        if (treeNode.left != null || treeNode.right != null) findAllLeaves(treeNode, finalArr);
        else finalArr.add(List.of(treeNode.val));
        return finalArr;
    }

    private static void deleteLeaves(TreeNode treeNode) {
        if (treeNode.left != null && treeNode.left.right == null && treeNode.left.left == null) treeNode.left = null;
        else if (treeNode.left != null) deleteLeaves(treeNode.left);
        if (treeNode.right != null && treeNode.right.left == null && treeNode.right.right == null) treeNode.right = null;
        else if (treeNode.right != null) deleteLeaves(treeNode.right);
    }

    private static List<Integer> getLeavesArr(TreeNode treeNode, List<Integer> arr) {
        if (treeNode.left != null) getLeavesArr(treeNode.left, arr);
        if (treeNode.right != null) getLeavesArr(treeNode.right, arr);
        if (treeNode.left == null && treeNode.right == null) arr.add(treeNode.val);
        return arr;
    }
}
