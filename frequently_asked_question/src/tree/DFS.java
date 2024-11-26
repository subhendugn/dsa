package tree;

public class DFS {
    void preOrder(Node root){
        // root -> left -> right
        if(root == null) return;

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
        // time complexity: O(n)
    }

    void inOrder(Node root){
        // left -> root -> right
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
        // time complexity: O(n)
    }

    void postOrder(Node root){
        // left -> right -> root
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");
        // time complexity: O(n)
    }

    public static void main(String[] args){
        DFS dfs = new DFS();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        dfs.inOrder(root); // 4 2 5 1 6 3 7
        System.out.println();
        dfs.preOrder(root); // 1 2 4 5 3 6 7
        System.out.println();
        dfs.postOrder(root); // 4 5 2 6 7 3 1
    }
}
