package org.example.integer;

import java.util.Stack;

public class Reverse {

    public static int reverse(int x) {
        if(x < 10 && x > -10) return x;
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }
        StringBuilder sbr = new StringBuilder();
        while(x / 10 > 0){
            int remainder = x%10;
            sbr.append(remainder);
            x = x /10;
            if(x  < 10) {
                sbr.append(x);
                break;
            }
        }

        int  result = 0;
        try{
             result = Integer.parseInt(sbr.toString());
        } catch (Exception e) {
        }
        if(isNegative){
            return -1 * result;
        }
        return result;
    }

    public static int reverse1(int x) {
        if(x < 10 && x > -10) return x;
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }
        StringBuilder sbr = new StringBuilder(String.valueOf(x));
        int  result = 0;
        try{
            result = Integer.parseInt(sbr.reverse().toString());
        } catch (Exception e) {
        }
        if(isNegative){
            return -1 * result;
        }
        return result;

    }

    public static void main(String[] args) {
        int a = 123;
        System.out.println(reverse(-123));
    }
}
