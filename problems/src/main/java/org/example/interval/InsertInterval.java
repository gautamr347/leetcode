package org.example.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] newIntervals = new int[intervals.length + 1][2];
        for(int i=0; i < intervals.length; i++){
            newIntervals[i] = intervals[i];
        }
        newIntervals[newIntervals.length-1] = newInterval;
        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        for(int i = 0; i<newIntervals.length; i++){
            int[] currentInterval = newIntervals[i];
            if(i == newIntervals.length-1){
                result.add(currentInterval);
                continue;
            }
            for(int j=i+1; j < newIntervals.length; j++){
                int[] nextInterval = newIntervals[j];
                if(isOverlapForSortedInterval(currentInterval[1], nextInterval[0])){
                    int d = Math.max(currentInterval[1], nextInterval[1]);
                    currentInterval[1] = d;
                    i = j;
                } else {
                    i = j - 1;
                    break;
                }
            }
            result.add(currentInterval);
        }
        int size = result.size();
        int[][] resultArray = new int[size][2];
        int counter = 0;
        for(int[] iter : result){
            resultArray[counter] = iter;
            counter++;
        }
        return resultArray;
    }

    private boolean isOverlapForSortedInterval(int b, int c){
        return c <= b;
    }
}
