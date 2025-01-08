package org.example.string;

public class AddSpaces {

    //https://leetcode.com/problems/adding-spaces-to-a-string/?envType=daily-question&envId=2024-12-03

    public static String addSpaces(String s, int[] spaces) {
        //sort space index array
        //iterate over space index array
        //create sublist and add in string builder
        if(spaces.length == 0) return s;
        if(s == null || s.isEmpty()) return s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s, 0, spaces[0]);
        if(spaces.length == 1){
            stringBuilder.append(" ");
            stringBuilder.append(s, spaces[0], s.length());
            return stringBuilder.toString();
        }

        for(int i=0; i<spaces.length-1; i++){
            stringBuilder.append(" ");
            stringBuilder.append(s, spaces[i], spaces[i+1]);
            if(i == spaces.length-2){
                stringBuilder.append(" ");
                stringBuilder.append(s, spaces[spaces.length-1], s.length());
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "EnjoyYourCoffee";
        int[] arr = {5, 9};
        System.out.println(addSpaces(str, arr));

    }
}
