package org.example.string;

public class KthCharacter {
    public static char kthCharacter(int k) {
        String str = "a";
        while (str.length() < k){
            StringBuilder temp = new StringBuilder();
            for(char ch : str.toCharArray()){
                if(ch == 122){
                    temp.append('a');
                }else {
                    char tempChar = (char) (ch +1);
                    temp.append(tempChar);
                }
            }
            str = "%s%s".formatted(str, temp.toString());
        }
        return str.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
