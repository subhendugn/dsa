package tree;

public class InsertInBinarySearchTree {
    public Node insert(Node root, int val) {
        Node t = new Node(val);
        if(root == null) return t;

        Node cur = root;
        while(true){
            if(val < cur.data) {
                if(cur.left == null) {
                    cur.left = t;
                    break;
                }
                else {
                    cur = cur.left;
                }

            }
            else {
                if(cur.right == null) {
                    cur.right = t;
                    break;
                }
                else{
                    cur = cur.right;
                }

            }

        }

        return root;
    }

    public static void main(String[] args){
        InsertInBinarySearchTree dfs = new InsertInBinarySearchTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.insert(root, 2));
    }
}
