package org.example.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        boolean isAdd = false;
        if(nums.length == 3) {
            return (nums[0] + nums[1] + nums[2]);
        }
        int min = Integer.MAX_VALUE;
        int i = 0;
        Arrays.sort(nums);
        //start from i to len - 2
        while(i < nums.length - 2){
            int j = i+1;
            int k = nums.length - 1;
            if(j == nums.length - 1){
                continue;
            }
            while(j < k){
                //find current diff and check it is min
                int currentSum = nums[i] + nums[j] + nums[k];
                int currentDiff = target > currentSum ? target - currentSum: currentSum - target;

                if(min > currentDiff){
                    isAdd = target <= currentSum;
                    min = currentDiff;
                }
                if(currentSum > target){
                    k--;
                } else if(currentSum < target){
                    j++;
                } else {return currentSum;}
            }
            i++;
        }
        if (isAdd) {
            return target + min;
        }
        return target - min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,8,9,10};
        System.out.println(threeSumClosest(arr, 16));

    }
}
