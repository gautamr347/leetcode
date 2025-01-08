package org.example.array;

//https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int nonZeroIndex = -1;
        while (i < nums.length-1){
            int currentElement = nums[i];
            if(currentElement != 0){
                i++;
            } else {
                if(nonZeroIndex < 0){
                    int j = i+1;
                    while(j < nums.length){
                        if(nums[j] == 0){
                            j++;
                        } else {
                          int temp = nums[j];
                          nums[j] = 0;
                          nums[i] = temp;
                          nonZeroIndex = j+1;
                          break;
                        }
                    }
                }else {
                    while (nonZeroIndex < nums.length){
                        if(nums[nonZeroIndex] == 0){
                            nonZeroIndex++;
                        }else {
                            int temp = nums[nonZeroIndex];
                            nums[nonZeroIndex] = 0;
                            nums[i] = temp;
                            nonZeroIndex++;
                            break;
                        }
                    }
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
