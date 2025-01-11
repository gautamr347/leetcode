package org.example.tree;

import java.util.*;

public class RightSideView {

    //https://leetcode.com/problems/binary-tree-right-side-view/submissions/1501940128/?envType=study-plan-v2&envId=top-interview-150

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            int levelSize = levelQueue.size();
            int counter = 1;
            Stack<Integer> levelStack = new Stack<>();
            while (counter <= levelSize) {
                TreeNode node = levelQueue.poll();
                if (node == null) {
                    counter++;
                    continue;
                }
                levelStack.add(node.val);
                if (node.leftNode != null) {
                    levelQueue.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    levelQueue.add(node.rightNode);
                }
                counter++;
            }
            result.add(levelStack.pop());
        }
        return result;
    }
}
