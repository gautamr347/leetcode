package org.example.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    private static Map<Integer, Integer> stairWaysMap = new HashMap<>();

    public static int climbStairs(int n){
        if(n <= 1) return 1;
        int ways1 = stairWaysMap.containsKey(n-1)? stairWaysMap.get(n-1) : climbStairs(n-1);
        stairWaysMap.put(n-1, ways1);
        int ways2 = stairWaysMap.containsKey(n-2) ? stairWaysMap.get(n-2) : climbStairs(n-2);
        stairWaysMap.put(n-2, ways2);
        return ways2 + ways1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
