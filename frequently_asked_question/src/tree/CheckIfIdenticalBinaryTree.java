package tree;

public class CheckIfIdenticalBinaryTree {
    boolean isIdentical(Node root1, Node root2){
        if(root1 == null || root2 == null) return root1 == root2;

        // if both are not null
        // check if data is same and left and right subtree are same
        // if any of the condition is false, return false
        // else return true
        // traverse the tree in pre-order fashion
        return root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args){
        CheckIfIdenticalBinaryTree dfs = new CheckIfIdenticalBinaryTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root1 = treeFormation.formTree();
        Node root2 = treeFormation.formTree();

        System.out.println(dfs.isIdentical(root1, root2)); // 3

    }
}
