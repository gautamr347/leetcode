package org.example.array.binary;

public class MinimumLimitOfBalls {



    public static int minimumSize(int[] nums, int maxOperations) {
        //greedy approach
        int expectedPenalty = 1;
        //find max of array
        int maxPenalty = Integer.MAX_VALUE;
//        for (int num : nums) {
//            if (maxPenalty < num) {
//                maxPenalty = num;
//            }
//        }
        while (expectedPenalty <= maxPenalty){
            if(maxPenalty == 1) return 1;
            int mid = Math.abs((expectedPenalty + maxPenalty) / 2);
            int numberOfOperations = 0;
            boolean found = true;
            for (int num : nums) {
                if (num <= mid) {
                    continue;
                }
                int currentNumberOfOperations = ((int) Math.ceil((double) num / mid)) - 1;
                numberOfOperations = numberOfOperations + currentNumberOfOperations;
                if (numberOfOperations > maxOperations) {
                    found = false;
                    expectedPenalty = mid;
                    break;
                }
            }
            if(found){
                maxPenalty = mid;
            } else {
                if(maxPenalty - mid == 1){
                    return maxPenalty;
                }
            }
        }
        return expectedPenalty;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        System.out.println(minimumSize(nums, 2));
    }

}
