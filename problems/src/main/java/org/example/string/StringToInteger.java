package org.example.string;

public class StringToInteger {

    /*
    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+',
    assuming positivity if neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is
    encountered or the end of the string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
    then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231,
    and integers greater than 231 - 1 should be rounded to 231 - 1.
     */

    public static int myAtoi(String s) {
        s = s.trim();
        if(s.isBlank()) return 0;
        boolean isNegative = false;
        if(s.charAt(0) == '-') isNegative = true;
        int endCounter = 0;
        if(isNegative) endCounter = 1;

        long value = 0;
        int multiplier = 1;

        for(int i = s.length() - 1; i>=endCounter; i--){
            long currentValue = Integer.parseInt(String.valueOf(s.charAt(i)));
            value = value + (currentValue * multiplier);
            if(value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(value < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            multiplier = multiplier * 10;
        }
        return (int)value;
    }

    public static void main(String[] args) {
        String str = "   -04200000000000000000000000000000000";
        System.out.println(myAtoi(str));
    }
}
