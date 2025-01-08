package org.example.array.heap;

public class HeapSort {

    /*
    1. Recursive approach
        a) heapify
        b) replace root to last node
        c) repeat
     */

    public static void heapSortRecursive(int[] arr){
        int n = arr.length;
        heapSortRecur(arr, n);
    }

    private static void heapSortRecur(int[] arr, int n){
        if(n < 1) return;
        maxHeapify(arr, n);
        int temp = arr[n-1];
        arr[n-1] = arr[0];
        arr[0] = temp;
        heapSortRecur(arr, n-1);
    }

    public static void heapSortIter(int arr[]){
        for(int i=arr.length-1 ; i >0; i--){
            maxHeapify(arr, i+1);
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
        }
    }



    private static void maxHeapify(int[] arr, int n){
        //iterate
        //check the constraint of max heap
        //swap in required
        for(int i=n/2; i >= 1; i--){
            maxHeapifyCurrentIndex(arr, i,n);
        }
    }

    private static void maxHeapifyCurrentIndex(int[] arr, int index, int n){
        int rootElement = arr[index-1];
        int leftChild = arr[2*index - 1];
        int rightChild = arr[2*index];
        int largestIndex = index;
        if(leftChild > rootElement && index <= n){
            largestIndex = 2*index <= n ? 2*index : largestIndex;
        }
        if(rightChild > rootElement && index <=n){
            largestIndex = 2*index + 1 <= n ? 2*index + 1: largestIndex;
        }
        if(largestIndex != index){
            arr[index - 1] = arr[largestIndex -1];
            arr[largestIndex-1] = rootElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5,10, 4,4,90, 1};
        heapSortIter(arr);
        System.out.println(arr);
    }
}
