package questions;

import java.util.*;

public class Question_31_ZigzagLevelOrderTraversal {

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
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(4, treeNode8, treeNode9);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        List<List<Integer>> lists = zigzagTraversal(treeNode1);
        System.out.println("lists = " + lists);

    }

    public static List<List<Integer>> zigzagTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int level = 0;
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(root, level));

        while (!queue.isEmpty()) {
            root = queue.peek().getKey();
            if (level != queue.peek().getValue()) {
                result.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                result.get(result.size() - 1).add(root.val);
            } else {
                result.get(result.size() - 1).add(0, root.val);
            }

            level = queue.poll().getValue();

            if (root.left != null) queue.add(new AbstractMap.SimpleEntry<>(root.left, level + 1));
            if (root.right != null) queue.add(new AbstractMap.SimpleEntry<>(root.right, level + 1));
        }
        return result;
    }
}
