package org.example.tree;

import java.util.*;

public class ReverseOddLevelNodes {

    public static TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root.leftNode);
        levelQueue.add(root.rightNode);

        int level = 1;
        Queue<TreeNode> currentLevelQueue = new LinkedList<>();
        Stack<Integer> currentLevelValue = new Stack<>();

        while (!levelQueue.isEmpty()){
            int size = levelQueue.size();
            for(int i = 0; i< size; i++){
                TreeNode node = levelQueue.poll();
                if(Objects.isNull(node))continue;
                //if level is even: only add node;
                if(level % 2 != 0) {
                    currentLevelQueue.add(node);
                    currentLevelValue.add(node.val);
                }
                //if odd: add node + do conversion
                levelQueue.add(node.leftNode);
                levelQueue.add(node.rightNode);
            }
            while (!currentLevelQueue.isEmpty()){
                TreeNode node = currentLevelQueue.poll();
                node.val = currentLevelValue.pop();
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode firstLeft = new TreeNode(3);
        TreeNode firstRight = new TreeNode(5);
        root.leftNode = firstLeft;
        root.rightNode = firstRight;
        //8,13
        TreeNode secondLeftFirst = new TreeNode(8);
        TreeNode secondLeftSecond = new TreeNode(13);
        firstLeft.leftNode = secondLeftFirst;
        firstLeft.rightNode = secondLeftSecond;

        //21,34
        TreeNode secondRightFirst = new TreeNode(21);
        TreeNode secondRightSecond = new TreeNode(34);
        firstRight.leftNode = secondRightFirst;
        firstRight.rightNode = secondRightSecond;

        reverseOddLevels(root);
    }

    public static TreeNode reverseOddLevelsRecursion(TreeNode root) {
        if(root == null){
            return root;
        }
        reverse(root.leftNode, root.rightNode, 1);
        return root;
    }

    private static void reverse(TreeNode node1, TreeNode node2, Integer depth){
        if(node1 == null) return;
        if(node2 == null) return;
        if(depth % 2 ==1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        reverse(node1.leftNode, node2.rightNode, depth + 1);
        reverse(node1.rightNode, node2.leftNode, depth + 1);
    }
}
