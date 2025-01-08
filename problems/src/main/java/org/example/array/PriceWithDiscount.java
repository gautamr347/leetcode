package org.example.array;

public class PriceWithDiscount {
    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/?envType=daily-question&envId=2024-12-18

    public int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        for(int i= 0; i<prices.length; i++){

            int discount = 0;
            int currentPrice = prices[i];
            for(int j=i+1; j < prices.length; j++){
                int nextPrice = prices[j];
                if(nextPrice<= currentPrice){
                    discount = nextPrice;
                    break;
                }
            }
            finalPrices[i] = currentPrice - discount;
        }
        return finalPrices;
    }
}
