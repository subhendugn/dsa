package tree;

public class CeilBinarySearchTree {
    public int ceil(Node root, int val) {
        int ceil = -1;

        while (root != null) {
            if(root.data == val) return root.data;
            else if(root.data > val){
                ceil = root.data;
                root = root.left;
            }
            else root = root.right;
        }

        return ceil;
    }

    public static void main(String[] args){
        CeilBinarySearchTree dfs = new CeilBinarySearchTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.ceil(root, 2));
    }
}
