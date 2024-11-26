package tree;

public class DiameterOfBinaryTree {
    int diameter(Node root){
        int[] result = new int[1];
        check(root, result);

        return result[0];

        // time complexity: O(n)
        // space complexity: O(h) where h is the height of the tree
    }
    int check(Node root, int[] result){
        if(root == null) return 0;

        int leftHeight = check(root.left, result);
        int rightHeight = check(root.right, result);

        result[0] = Math.max(result[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args){
        DiameterOfBinaryTree dfs = new DiameterOfBinaryTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.diameter(root)); // 3

    }
}
