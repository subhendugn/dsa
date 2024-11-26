package tree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    Node lca(Node root, int p, int q){

        // base case
        if(root == null || root.data == p || root.data == q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        // result
        if(left == null) return right;
        if(right == null) return left;
        else return root;
    }

    public static void main(String[] args){
        LowestCommonAncestor dfs = new LowestCommonAncestor();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.lca(root, 4, 3)); // 1
    }
}
