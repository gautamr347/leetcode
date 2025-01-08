package org.example.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MarkElements {



        public long findScore(int[] nums) {

            long score = 0;
            Set<Integer> indexMarked = new HashSet<>();
            return findScore(nums, indexMarked, 0);
        }

        private long findScore(int[] nums, Set<Integer> indexMarked, long score){
            if(indexMarked.size() >= nums.length){
                return score;
            }
            Integer min = Integer.MAX_VALUE;
            Integer minIndex = -1;
            for(int i= 0; i<nums.length; i++){
                if(indexMarked.contains(i)) continue;

                if(nums[i] < min){
                    min = nums[i];
                    minIndex = i;
                }
            }
            if(minIndex == 0){
                indexMarked.add(minIndex);
                indexMarked.add(minIndex + 1);
            }else if(minIndex == nums.length - 1){
                indexMarked.add(minIndex);
                indexMarked.add(minIndex - 1);
            }else {
                indexMarked.add(minIndex);
                indexMarked.add(minIndex + 1);
                indexMarked.add(minIndex - 1);
            }
                score = score + min;
                return findScore(nums, indexMarked, score);
        }

    public static long findScoreOpt(int[] nums) {
            int[][] dp = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }
        Arrays.sort(dp, (a, b) -> a[0] - b[0]);
        Set<Integer> indexMarked = new HashSet<>();
        long score = 0;
        for(int[] c:dp){
            int val = c[0];
            var index = c[1];
            if(indexMarked.contains(index)){
                continue;
            }
            score = score + (long)val;
            indexMarked.add(index);
            indexMarked.add(index-1);
            indexMarked.add(index+1);
        }

        return score;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 7};
        //findScoreOpt(a);
        String str = "Thisisanexampleoftextjustification.";

        String str2 = "What must be acknowledgment shall be";
        System.out.println(str2.length());
    }
}
