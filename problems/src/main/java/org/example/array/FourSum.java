package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        //fix firsts cursor
        while (i < nums.length - 3){
            int j = i + 1;
        //fix 2nd cursor
            while (j < nums.length - 2){
                int k = j + 1;
                if(nums[i] + nums[j] + nums[k] > target){
                    break;
                }
                int l = nums.length - 1;
                //move 2 pointer
                while (k < l){
                    long currentSum = Long.valueOf(nums[i])+ Long.valueOf(nums[j]) + Long.valueOf(nums[k]) + Long.valueOf(nums[l]);
                    if(currentSum > target){
                        l--;
                    } else if(currentSum < target) {
                        k++;
                    } else {
                        var newList = List.of(nums[i], nums[j], nums[k], nums[l]);
                        if(!result.contains(newList)){
                            result.add(newList);
                        }
                        break;
                    }
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(a, -294967296));
    }
}
