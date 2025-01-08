package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class MaxCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;

        for(int candy : candies){
            if(max < candy) {
                max = candy;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int candy : candies){
            if(candy + extraCandies >= max){
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
