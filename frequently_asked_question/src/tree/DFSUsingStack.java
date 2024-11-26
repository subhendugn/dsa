package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSUsingStack {
    List<Integer> preOrder(Node root){
        // root -> left -> right
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            root = stack.pop();
            result.add(root.data);

            // push the right
            // push the left
            // so that left will be at the top of the stack
            // and will be processed first
            // as stack is LIFO (Last In First Out)
            // so left will be processed first
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }

        return result;

        // time complexity: O(n)
        // space complexity: O(n)
    }

    List<Integer> inOrder(Node root){
        // left -> root -> right
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (true){
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if(stack.isEmpty()) break;
                current = stack.pop();
                result.add(current.data);
                current = root.right;
            }
        }

        // time complexity: O(n)
        // space complexity: O(n)
        return result;
    }

    void postOrder(Node root){
        // left -> right -> root
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");
        // time complexity: O(n)
        // space complexity: O(n)
    }

    public static void main(String[] args){
        DFSUsingStack dfs = new DFSUsingStack();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.inOrder(root)); // 4 2 5 1 6 3 7
        System.out.println();
        System.out.println(dfs.preOrder(root)); // 1 2 4 5 3 6 7
        System.out.println();
        dfs.postOrder(root); // 4 5 2 6 7 3 1
    }
}
