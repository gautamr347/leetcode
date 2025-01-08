package org.example.interval;

import java.util.Arrays;
import java.util.List;

public class MergeIntervalNaive {

    public static List<int[]> mergeIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i= 0; i< intervals.length-1; i++){
            int[] firsInterval = intervals[i];
            for( int j = i+1; j < intervals.length; j++){


            }
        }
        return List.of();
    }

}
