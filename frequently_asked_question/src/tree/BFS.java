package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public List<List<Integer>> levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size(); // number of nodes in the current level
            List<Integer> subList = new LinkedList<>();

            // iterate through all the nodes in the current level
            for(int i=0; i<size; i++){
                // remove the node from the front of the queue
                Node current = queue.poll();

                // add the children of the node to the queue
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

                // add the node to the sublist
                subList.add(current.data);
            }
            result.add(subList);
        }

    return result;

        // time complexity: O(n)
        // space complexity: O(n)
    }

    public static void main(String[] args) {
        BFS  bfs = new BFS();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(bfs.levelOrder(root)); // [[1], [2, 3], [4, 5, 6, 7]]

    }
}
