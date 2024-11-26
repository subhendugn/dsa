package tree;

public class KthSmallestElementInBST {
    int counter = 0;
    int result = 0;
    public int kthSmallest(Node root, int k) {

        // int counter = 0;
        inorder(root, k);
        return result;
    }

    public void inorder(Node root, int k){
        if(root == null){
            return;
        }

        // left -> root -> right
        inorder(root.left, k);
        counter++;
        if(counter == k) {
            result = root.data;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args){
        KthSmallestElementInBST dfs = new KthSmallestElementInBST();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.kthSmallest(root, 1));
    }
}
