package org.example.tree;

import java.util.*;

public class MinOpToSortLevel {
    //https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/?envType=daily-question&envId=2024-12-23

    public static int minimumOperations(TreeNode root) {

        if (Objects.isNull(root))
            return 0;
        // level order traversal
        // each level check values are sorted
        // if not sort
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if(Objects.nonNull(root.leftNode)){
            levelQueue.add(root.leftNode);
        }
        if(Objects.nonNull(root.rightNode)){
            levelQueue.add(root.rightNode);
        }
        Integer waysToSort = 0;
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            int[] currentLevelArr = new int[size];
            for(int i=0; i<size; i++){
                TreeNode currentNode = levelQueue.poll();
                if (Objects.isNull(currentNode)) {
                    continue;
                }
                currentLevelArr[i] = currentNode.val;
                if(Objects.nonNull(currentNode.leftNode)){
                    levelQueue.add(currentNode.leftNode);
                }
                if(Objects.nonNull(currentNode.rightNode)){
                    levelQueue.add(currentNode.rightNode);
                }

            }
            waysToSort = waysToSort + minSwap(currentLevelArr);
        }
        return waysToSort;
    }

    private static int minSwap(int[] arr){
        //clone array
        //sort array
        //create value index map
        //update the array and count
        if(arr.length == 0 || arr.length == 1) return 0;
        int[] clonedArray = arr.clone();
        Arrays.sort(clonedArray);
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < clonedArray.length; i++){
            valueIndexMap.put(clonedArray[i], i);
        }
        int numberOfSwap = 0;
        for(int i=0; i<arr.length; i++){
            if(valueIndexMap.get(arr[i]) != i){
                int nextIndex = valueIndexMap.get(arr[i]);
                int temp = arr[i];
                arr[i] = arr[nextIndex];
                arr[nextIndex] = temp;
                i--;
                numberOfSwap++;
            }
        }
        return numberOfSwap;
    }

    public static void main(String[] args) {
       // int[] arr = {9,10};
        //System.out.println(minSwap(arr));

        TreeNode root = new TreeNode(31);
        TreeNode f11 = new TreeNode(28);
        //TreeNode f12 = new TreeNode(3);
        root.leftNode = f11;
        //root.rightNode = f12;

        TreeNode f21 = new TreeNode(42);
        //TreeNode f22 = new TreeNode(6);
        f11.leftNode = f21;
        //f11.rightNode = f22;
        //TreeNode f23 = new TreeNode(8);
        //TreeNode f24 = new TreeNode(5);
        //f12.leftNode = f23;
        //f12.rightNode = f24;

        f21.rightNode = new TreeNode(7);
        System.out.println(minimumOperations(root));

    }
}
