package tree;

public class FloorBinarySearchTree {
    public int floor(Node root, int val) {

        int floor = -1;

        while(root != null){
            if(root.data == val) return root.data;
            else if(root.data > val) root = root.left;
            else{
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }

    public static void main(String[] args){
        FloorBinarySearchTree dfs = new FloorBinarySearchTree();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.floor(root, 2));
    }
}
