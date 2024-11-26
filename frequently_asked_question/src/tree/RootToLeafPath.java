package tree;

import java.util.ArrayList;

public class RootToLeafPath {
    void rootToLeafPath(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths){
        // possible path to all leaf nodes
        if(root == null) return;

        path.add(root.data);

        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }

        rootToLeafPath(root.left, path, paths);
        rootToLeafPath(root.right, path, paths);

    }

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        RootToLeafPath dfs = new RootToLeafPath();
        dfs.rootToLeafPath(root, path, paths);
        return paths;
    }

    public static void main(String[] args){
        RootToLeafPath dfs = new RootToLeafPath();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.Paths(root) ); // [1, 2, 5]
    }
}
