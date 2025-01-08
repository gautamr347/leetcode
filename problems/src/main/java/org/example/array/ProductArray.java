package org.example.array;

import java.util.Arrays;

public class ProductArray {

    //Given an integer array nums, return an array answer such that answer[i] is equal to the product of
    // all the elements of nums except nums[i]

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        Arrays.fill(prefix, 1);

        int[] suffix = new int[length];
        Arrays.fill(suffix, 1);
        for(int i =1; i < length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i =length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        int[] result = new int[length];
        for (int i=0; i< length; i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;

    }
}
