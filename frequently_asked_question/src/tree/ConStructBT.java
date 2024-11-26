package tree;

import java.util.HashMap;
import java.util.Map;

public class ConStructBT {
    public Node constructBTFromInorderAndPreOrder(int[] inorder, int[] preorder){
        Map<Integer, Integer> map = new HashMap<>();

        // put inorder elements in map
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        Node root = constructInPre(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, map);

        return root;
    }

    public Node constructInPre(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = constructInPre(inorder, preorder, inStart, inRoot - 1, preStart + 1, preStart + numsLeft, map);
        root.right = constructInPre(inorder, preorder, inRoot + 1, inEnd, preStart + numsLeft + 1, preEnd, map);

        return root;
    }

    public Node constructBTFromInoderAndPostOrder(int[] inorder, int[] postorder){
        Map<Integer, Integer> map = new HashMap<>();

        // put inorder elements in map
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        Node root = constructInPost(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);

        return root;
    }

    public Node constructInPost(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd) return null;

        Node root = new Node(postorder[postEnd]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = constructInPost(inorder, postorder, inStart, inRoot - 1, postStart, postStart + numsLeft - 1, map);
        root.right = constructInPost(inorder, postorder, inRoot + 1, inEnd, postStart + numsLeft, postEnd - 1, map);



        return root;
    }



        public static void main(String[] args){
        ConStructBT dfs = new ConStructBT();
        TreeFormation treeFormation = new TreeFormation();
        Node root = treeFormation.formTree();
        System.out.println(dfs.constructBTFromInorderAndPreOrder(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{1, 2, 4, 5, 3, 6, 7}));
        System.out.println(dfs.constructBTFromInoderAndPostOrder(new int[]{9, 3, 15, 20, 7}, new int[]{3, 9, 20, 15, 7}));
    }
}


