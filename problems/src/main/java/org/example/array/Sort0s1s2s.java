package org.example.array;

public class Sort0s1s2s {
    //https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

    public static void sort012(int[] arr) {
        int zeroesCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int ar: arr){
            if(ar == 0) zeroesCount++;
            if(ar == 1) oneCount++;
            if(ar == 2) twoCount++;
        }

        if(zeroesCount != 0){
            for(int i=0; i<zeroesCount; i++){
                arr[i] = 0;
            }
        }

        if(oneCount != 0){
            for(int i=zeroesCount; i<oneCount + zeroesCount; i++){
                arr[i] = 1;
            }
        }

        if(twoCount != 0){
            for(int i=oneCount+zeroesCount; i<twoCount + zeroesCount + oneCount; i++){
                arr[i] = 2;
            }
        }
        // code here
    }

    public static void main(String[] args) {
        int[] arr= {0, 1, 2, 0, 1, 2};

        sort012(arr);
    }

}
