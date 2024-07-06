package org.example.array;


//https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int[] indexArray = new int[Integer.MAX_VALUE];
        for (int num : nums) {
            indexArray[num] = indexArray[num] + 1;
        }

        int counter = 0;
        boolean started = false;

        for (int i = 0; i < indexArray.length; i++) {
            var element = indexArray[i];
            if (!started) {
                if (element > 0) {
                    started = true;
                    counter++;
                }
            } else {
                if (element > 0) {
                    counter++;
                } else {
                    return counter;
                }
            }
        }
        return counter;
    }

}
