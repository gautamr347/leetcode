package org.example.tree.bst;

import org.example.tree.TreeNode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class MinAbsDiff {

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        List<Integer> listValues = new ArrayList<>();
        inOrder(root, listValues);
        if(listValues.size() == 1) return listValues.get(0);
        int minDiff = Integer.MAX_VALUE / 100;
        for(int i = 0; i < listValues.size() - 1; i++){
            minDiff = Math.min(minDiff, Math.abs(listValues.get(i) - listValues.get(i+1)));
        }
        return minDiff;
    }

    private void inOrder(TreeNode node, List<Integer> values){
        if(node == null) return;
        inOrder(node.leftNode, values);
        values.add(node.val);
        inOrder(node.rightNode, values);
    }
}
