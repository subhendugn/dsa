package tree;

public class CheckIfBalancedBinaryTree {
    String isBaancedBT(Node root){
        if(check(root) == -1) return "Not Balanced tree";
        return "Balanced tree";

        // time complexity: O(n)
        // space complexity: O(h) where h is the height of the tree
    }
    int check(Node root){
        if(root == null) return 0;

        int leftHeight = check(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = check(root.right);
        if (rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args){
        CheckIfBalancedBinaryTree dfs = new CheckIfBalancedBinaryTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.isBaancedBT(root)); // 3

    }
}
