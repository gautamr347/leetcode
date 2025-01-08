package org.example.interval;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150
public class MergeInterval {
    //TODO

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] leftInterval = intervals[i];
            if (leftInterval.length != 2) continue;
            for (int j = i + 1; j < intervals.length; j++) {
                int[] rightInterval = intervals[j];
                if (rightInterval.length != 2) continue;
                //if(leftInterval[])

            }
        }
        int counter = 0;
        for (int[] interval : intervals) {
            if (interval.length == 2) {
                counter++;
            }
        }
        int[][] result = new int[counter][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (interval.length != 2) continue;
            result[i] = interval;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] interval = new int[4][2];
        interval[0] = new int[]{1, 3};
        interval[1] = new int[]{2, 6};
        interval[2] = new int[]{8, 10};
        interval[3] = new int[]{15, 18};

        merge(interval);
    }
}
