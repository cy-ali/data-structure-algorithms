package questions;

public class Question_28_InvertBinaryTree {

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

//        TreeNode treeNode = invertTree(treeNode1);
//        invertTree(treeNode);
        swapTree(treeNode1);
        invertTree(treeNode1);
    }

    public static TreeNode invertTree(TreeNode originalTree) {
        TreeNode resultTree = new TreeNode();
        resultTree.val = originalTree.val;
        return invertTree(originalTree, resultTree);
    }

    private static TreeNode invertTree(TreeNode originalTree, TreeNode resultTree) {

        if (originalTree.left != null) {
            resultTree.right = new TreeNode(originalTree.left.val);
            invertTree(originalTree.left, resultTree.right);
        }
        if (originalTree.right != null) {
            resultTree.left = new TreeNode(originalTree.right.val);
            invertTree(originalTree.right, resultTree.left);
        }
        return resultTree;
    }

    public static TreeNode swapTree(TreeNode treeNode) {

        if (treeNode == null) return null;

        TreeNode tempTree;
        tempTree = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tempTree;

        swapTree(treeNode.left);
        swapTree(treeNode.right);

        return treeNode;
    }

}
