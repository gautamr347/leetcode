package org.example.set;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCounter = 0;
        for (int num : nums) {
            int length = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + length)) {
                    length++;
                }
                maxCounter = Math.max(maxCounter, length);
            }
        }
        return maxCounter;
    }
}
