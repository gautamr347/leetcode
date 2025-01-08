package org.example.array;

import java.util.Arrays;

public class MaxAvgPassRatio {


    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        //cretae a 2d Array estimated diff vs current ratio
        //sort in each iteration
        //assign the student to the class
        double[][] diffRatioArr = new double[classes.length][2];
            for(int i = 0; i < classes.length; i++){
                var pass = classes[i][0];
                var total = classes[i][1];
                double incrementedRatio = (double)(pass + 1) / (total + 1);
                double existingRatio = (double)(pass) / (total);
                double diff = incrementedRatio - existingRatio;
                diffRatioArr[i][0] = diff;
                diffRatioArr[i][1] = existingRatio;
            }
            Arrays.sort(diffRatioArr, (a, b) -> Double.compare(a[0], b[0]));
            while (extraStudents > 0){
                extraStudents --;
                diffRatioArr[classes.length-1][1] = diffRatioArr[classes.length-1][0];
                //diffRatioArr[classes.length-1][0] =

            }
            return 0;
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        //[[2,4],[3,9],[4,5],[2,10]]
        int[] a = {2,4};
        int[] b = {3,9};
        int[] c= {4,5};
        int[] d = {2, 10};

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        System.out.println(maxAverageRatio(arr, 2));

    }

}
