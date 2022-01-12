package questions;

public class Question_27_SumOfNodeDepths {

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
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(4, treeNode8, treeNode9);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(getSumOfDepths(treeNode1));
    }

    public static int getSumOfDepths(TreeNode treeNode) {
        int sum = 0;
        int depth = -1;
        return addDepthsInOrder(treeNode, depth, sum);
    }

    private static int addDepthsInOrder(TreeNode treeNode, int depth, int sum) {
        depth += 1;
        if (treeNode.left != null) sum = addDepthsInOrder(treeNode.left, depth, sum);
        if (treeNode.right != null) sum = addDepthsInOrder(treeNode.right, depth, sum);
        sum += depth;
        return sum;
    }

}
