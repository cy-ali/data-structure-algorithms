package day4_trees;

public class MainAppTrees {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        int[] nums = {10, 6, 8, 20, 4, 9, 5, 17, 42, 47, 29};

        for (int num : nums) {
            myTree.insert(num);
        }

        myTree.traversePreOrder();
        System.out.println("\n--------------------");
        myTree.traverseInOrder();
        System.out.println("\n--------------------");
        myTree.traversePostOrder();
    }
}
