package org.example.tree;

import java.util.*;

public class LargestValueInRow {

    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2024-12-25

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return List.of();
        List<Integer> largestArray = new ArrayList<>();

        Queue<TreeNode> levelQueue = new LinkedList<>();
        largestArray.add(root.val);
        if(root.leftNode != null) levelQueue.add(root.leftNode);
        if(root.rightNode != null) levelQueue.add(root.rightNode);

        while (!levelQueue.isEmpty()){
            int size = levelQueue.size();
            int max = levelQueue.peek().val;

            for(int i=0; i<size; i++){
                var node = levelQueue.poll();
                if(node == null) continue;
                if(max < node.val){
                    max = node.val;
                }
                if(Objects.nonNull(node.leftNode)) levelQueue.add(node.leftNode);
                if(Objects.nonNull(node.rightNode)) levelQueue.add(node.rightNode);
            }
            largestArray.add(max);
        }
        return largestArray;
    }
}
