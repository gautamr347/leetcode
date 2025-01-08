package org.example.tree;

public class TreeNode {
    public int val;
    public TreeNode leftNode;
    public TreeNode rightNode;
    TreeNode(){}

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.leftNode = left;
        this.rightNode = right;
    }


}
