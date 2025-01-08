package org.example.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxChunk {

    public int maxChunksToSorted(int[] arr) {
        if(arr.length == 0 ) return 0;

        int[] maxArra = new int[arr.length];
        Integer currentMax = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > currentMax){
                currentMax = arr[i];
                maxArra[i] = currentMax;
            }else {
                maxArra[i] = currentMax;
            }
        }
        int count = 0;
        for(int i = 0; i < maxArra.length; i++){
            if(i == maxArra[i]) count++;
        }
        return count;
    }
}
