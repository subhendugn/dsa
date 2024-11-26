package tree;

public class MaximumPathSum {
    int maxPathSum(Node root){
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        check(root, result);

        return result[0];

        // time complexity: O(n)
        // space complexity: O(h) where h is the height of the tree
    }
    int check(Node root, int[] result){
        if(root == null) return 0;

        int leftSum = Math.max(0, check(root.left, result));
        int rightSum = Math.max(0, check(root.right, result));

        result[0] = Math.max(result[0], leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }

    public static void main(String[] args){
        MaximumPathSum dfs = new MaximumPathSum();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();

        System.out.println(dfs.maxPathSum(root)); // 3

    }
}
