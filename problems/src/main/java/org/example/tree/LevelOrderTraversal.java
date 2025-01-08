package org.example.tree;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(Objects.isNull(root)) return List.of();
        List<List<Integer>> orderList = new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()){
            int size = tempQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i= 0; i<size; i++){
                TreeNode node = tempQueue.poll();
                if(Objects.isNull(node)){
                currentLevel.add(null);
                continue;
                }
                currentLevel.add(node.val);
                if(Objects.nonNull(node.leftNode)) tempQueue.add(node.leftNode);
                if(Objects.nonNull(node.rightNode)) tempQueue.add(node.rightNode);
            }
            orderList.add(currentLevel);
        }
        return orderList;
    }
}
