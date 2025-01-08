package org.example.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShopTiming {
    //You are given two arrays which represent open and close timings of a store.
    // You have to print the schedule. if any of the timing is greater than 2400 ,
    // you will have to print closed and if the timing for open and close are same you have to
    // print Open 24 hours Example: Input
    // Open [900,1000,1000,1000,2700,1200,800]
    // Close - [1700,1600,1600,1600,1600,1200,800]
    // Output:
        // Mon: 900-1700
        // Tue-Thur: 1000-1600
        // Fri: Closed
        // Sat-Sun: Open 24 Hours

    public static void timing(int[] open, int[] closed){
        Map<Integer, String> indexDayMapping = new HashMap<>();
        indexDayMapping.put(0, "Mon");
        indexDayMapping.put(1, "Tue");
        indexDayMapping.put(2, "Wed");
        indexDayMapping.put(3, "Thu");
        indexDayMapping.put(4, "Fri");
        indexDayMapping.put(5, "Sat");
        indexDayMapping.put(6, "Sun");
        String[] time = new String[7];
        for(int i=0 ;i< 7; i++){
            if(open[i] > 2400 || closed[i] > 2400){
                time[i] = "Closed";
            } else if(open[i] == closed[i]){
                time[i] = "Open 24 Hours";
            } else {
                time[i] = "%d - %d".formatted(open[i], closed[i]);
            }
        }

        int beginIndex = 0;
        int endIndex = 0;
        for(int i=1;i<7; i++){
            if(Objects.equals(time[i], time[i - 1])){
                endIndex++;
                if(i==6){
                    if(beginIndex != endIndex){
                        System.out.println("%s - %s: %s".formatted(indexDayMapping.get(beginIndex), indexDayMapping.get(endIndex), time[beginIndex]));
                    } else {
                        System.out.println("%s: %s".formatted(indexDayMapping.get(beginIndex), time[beginIndex]));
                    }
                    break;

                }
            } else if(beginIndex == endIndex){
                System.out.println("%s: %s".formatted(indexDayMapping.get(beginIndex), time[beginIndex]));
                beginIndex=i;
                endIndex=i;

            } else if(beginIndex != endIndex){
                System.out.println("%s - %s: %s".formatted(indexDayMapping.get(beginIndex), indexDayMapping.get(endIndex), time[beginIndex]));
                beginIndex=i;
                endIndex=i;
            } else if(i == 6){
                System.out.println("%s: %s".formatted(indexDayMapping.get(i), time[i]));
            }
        }
    }

    public static void main(String[] args) {
        int[] open = {900,1000,1000,1000,2700,1200,800};
        int[] close = {1700,1600,1600,1600,1600,1200,800};

        timing(open, close);
    }


}
