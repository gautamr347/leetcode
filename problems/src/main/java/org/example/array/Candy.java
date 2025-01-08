package org.example.array;

public class Candy {

    public static int candy(int[] ratings) {
        //
        int[] candies = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++){
            candies[i] = 1;
        }

        for(int i=1; i< ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i]++;
            }
        }
        int candiesSum = candies[ratings.length -1];
        for(int i = ratings.length - 2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i]++;
            }
            candiesSum = candiesSum + candies[i];
        }
        return candiesSum;
    }

    public static void main(String[] args) {
        int[] rat = {1,3,2,2,1};
        System.out.println(Candy.candy(rat));
    }
}
