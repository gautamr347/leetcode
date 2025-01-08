package org.example.set;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/submissions/1472569166/?envType=daily-question&envId=2024-12-06

public class MaxNumberOfInteger {
    public static int maxCount(int[] banned, int n, int maxSum) {
        //create set
        //create a list of integer not in set and sum is <= maxSum

        Set<Integer> bannedSet = new HashSet<>();
        for(int i = 0; i < banned.length; i++){
            bannedSet.add(banned[i]);
        }
        int counter =0;
        int currentSum = 0;
        int integerSelected = 0;
        while(counter < n){
            counter++;
            if(bannedSet.contains(counter)) continue;

            if(currentSum + counter < maxSum) {
                currentSum = currentSum + counter;
                integerSelected++;
            } else {
                break;
            }
        }
        return integerSelected;
    }

    public static void main(String[] args) {
        int[] a = {11};
        maxCount(a, 7, 50);
    }
}
