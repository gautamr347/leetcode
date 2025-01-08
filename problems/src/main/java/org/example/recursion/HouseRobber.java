package org.example.recursion;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    //https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150

    Map<Integer, Integer> houseAmountMap = new HashMap<>();

    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int houseCounter) {
        if (houseCounter < 0) return 0;
        int am = 0;
        if (houseAmountMap.containsKey(houseCounter)) {
            return houseAmountMap.get(houseCounter);
        } else {
            int am1 = rob(nums, houseCounter - 2);
            houseAmountMap.put(houseCounter - 2, am1);
            int am2 = rob(nums, houseCounter - 1);
            houseAmountMap.put(houseCounter - 1, am2);
            am = Math.max(am1 + nums[houseCounter], am2);
            houseAmountMap.put(houseCounter, am);
        }
        return am;
    }
}
