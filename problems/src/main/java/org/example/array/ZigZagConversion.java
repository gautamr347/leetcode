package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> stringBuilderList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            StringBuilder str = new StringBuilder();
            stringBuilderList.add(str);
        }
        int j = 0;
        boolean forward = true;
        for (int i = 0; i < s.length(); i++) {
            if (j == numRows - 1) {
                forward = false;
            } else if (j == 0) {
                forward = true;
            }
            stringBuilderList.get(j).append(s.charAt(i));
            if (forward) {
                j++;
            } else {
                j--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilderList) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
