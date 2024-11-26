package tree;

import java.util.ArrayList;

public class RootToNodePath {
    boolean rootToNodePath(Node root, int n, ArrayList<Integer> path){
        if(root == null) return false;

        path.add(root.data);

        if(root.data == n) return true;

        if(rootToNodePath(root.left, n, path) || rootToNodePath(root.right, n, path)) return true;

        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args){
        RootToNodePath dfs = new RootToNodePath();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(dfs.rootToNodePath(root, 5, path)); // true
        System.out.println(path); // [1, 2, 5]
    }
}
