package org.example.tree;

import java.util.*;

public class ZigZagLevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if(Objects.isNull(root)) return List.of();
        List<List<Integer>> orderList = new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        boolean rightToLeft = true;
        while (!tempQueue.isEmpty()){
            int size = tempQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i= 0; i<size; i++){
                TreeNode node = tempQueue.poll();
                currentLevel.add(node.val);
                if(Objects.nonNull(node.leftNode)) tempQueue.add(node.leftNode);
                if(Objects.nonNull(node.rightNode)) tempQueue.add(node.rightNode);
            }
            if(!currentLevel.isEmpty()){
                if(rightToLeft){
                    orderList.add(currentLevel);
                    rightToLeft = false;
                }else {
                    Collections.reverse(currentLevel);
                    orderList.add(currentLevel);
                    rightToLeft = true;
                }
            }
        }
        return orderList;
    }
}
