package tree;

public class SearchInBinarySearchTree {
    public Node searchBST(Node root, int val) {
        while(root != null && root.data != val){
            if(val < root.data) root = root.left;
            else root = root.right;
        }
        return root;
    }

    public static void main(String[] args){
        SearchInBinarySearchTree dfs = new SearchInBinarySearchTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.searchBST(root, 2)); // 2
    }
}
