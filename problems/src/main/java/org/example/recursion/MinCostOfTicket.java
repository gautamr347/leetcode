package org.example.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostOfTicket {

    //https://leetcode.com/problems/minimum-cost-for-tickets/?envType=daily-question&envId=2024-12-31

    public static int minCostTickets(int[] days, int[] costs) {
        Arrays.sort(days);

        //each day purchase 1day, 7day, 15 day
        // track price

        //initialize pass day map
        int day = days[0];
        Map<Integer, Integer> passDayMap = new HashMap<>();
        passDayMap.put(0, -365);
        passDayMap.put(1, -365);
        passDayMap.put(2, -365);
        int totalCost = 0;


        return totalCost;
    }

    private static int minCost(int[] days, int index, Map<Integer, Integer> passDayMap, int[] costs){
        if(index >= days.length) return 0;

        int day = days[index];
        return 0;

    }

    private static int minCost(int[] days, int index, int costIndex, Map<Integer, Integer> passDayMap, int[] costs){
        if(index >= days.length) return 0;

        int day = days[index];
        int passBought = passDayMap.get(costIndex);
        if(isPassExpired(day, passBought, costIndex)){
            passDayMap.put(costIndex, costs[costIndex]);
            return costs[costIndex];
        }else {
            return 0;
        }
    }

    private static boolean isPassExpired(int currentDay, int passBoughtDay, int passType){
        if(passType == 0){
            return currentDay == passBoughtDay;
        }else if (passType == 1){
            return currentDay >= passBoughtDay && currentDay < passBoughtDay + 7;
        } else {
            return currentDay >= passBoughtDay && currentDay < passBoughtDay + 30;
        }
    }
}
