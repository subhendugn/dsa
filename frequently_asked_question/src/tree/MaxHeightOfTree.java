package tree;

public class MaxHeightOfTree {
    int maxHeight(Node root){
        if(root == null) return 0;

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args){
        MaxHeightOfTree dfs = new MaxHeightOfTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.maxHeight(root)); // 3

    }
}
