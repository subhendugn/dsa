package tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraverse(root, result);
        return result;
    }

    public List<Integer> postorderTraverse(TreeNode root, List<Integer>  result) {
        if(root == null) return result;

        // left
        postorderTraverse(root.left, result);

        // right
        postorderTraverse(root.right, result);

        // root
        result.add(root.val);

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = inorderTraverse(root, result);
        return result;
    }

    public List<Integer> inorderTraverse(TreeNode root, List<Integer> result) {
        if(root == null) return result;

        // left
        inorderTraverse(root.left, result);

        // root
        result.add(root.val);

        // right
        inorderTraverse(root.right, result);

        return result;
    }

    public List<Integer> preorderTraverse(TreeNode root,List<Integer> result) {
        if(root == null) return result;

        // root
        result.add(root.val);

        // left
        preorderTraverse(root.left, result);

        // right
        preorderTraverse(root.right, result);

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // root -> left -> right
        List<Integer> result = new ArrayList<>();

        result = preorderTraverse(root,result);

        return result;
    }
}
