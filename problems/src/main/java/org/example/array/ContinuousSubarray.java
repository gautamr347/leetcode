package org.example.array;

import java.util.Arrays;

public class ContinuousSubarray {

    public long continuousSubarrays(int[] nums) {
        //find greatest subArray
        int[][] indexArray = new int[nums.length][2];
        for(int i =0; i<nums.length; i++){
            indexArray[i][0] = nums[i];
            indexArray[i][1] = i;
        }
        Arrays.sort(indexArray, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j= 1;

        //while (i)
        return 0;
    }
}
