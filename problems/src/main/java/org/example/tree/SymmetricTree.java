package org.example.tree;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.leftNode, root.rightNode);
    }

    private static boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val &&
                isMirror(left.rightNode, right.leftNode) &&
                isMirror(left.leftNode, right.rightNode) ;
    }
}
