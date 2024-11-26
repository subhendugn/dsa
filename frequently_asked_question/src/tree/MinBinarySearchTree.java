package tree;

public class MinBinarySearchTree {
    public int min(Node root, int val) {

        if(root == null) return -1;
        if(root.left == null) return root.data;

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static void main(String[] args){
        MinBinarySearchTree dfs = new MinBinarySearchTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.min(root, 2)); // 2
    }
}
