package org.example.array;

import java.util.Arrays;

public class ArrayState {

    public int[] getFinalState(int[] nums, int k, int multiplier) {


        for(int j=0; j<k; j++){
            Integer min = Integer.MAX_VALUE;
            Integer index = -1;
            for(int i= 0; i<nums.length; i++) {
                if(nums[i] < min){
                    index =i;
                    min = nums[i];
                }
            }
            nums[index] = nums[index] * multiplier;
        }
        return nums;
    }


}
