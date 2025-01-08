package org.example.string;

public class Substring {

    public static int countOfSubstrings(String word, int k) {
        char aVow = 'a';
        char eVow = 'e';
        char iVow = 'i';
        char oVow = 'o';
        char uVow = 'u';

        int subStringLth = k + 5;
        if(word.length() < subStringLth) return 0;
        int resultCounter = 0;
        while (true){
            //iterate & check substr with length subStringLth
            for(int i = 0; i <= word.length() - subStringLth; i++){
                var subStr = word.substring(i, i + subStringLth);
                int conCount = 0;
                boolean aFound = false;
                boolean eFound = false;
                boolean iFound = false;
                boolean oFound = false;
                boolean uFound = false;
                for(int j = 0; j < subStr.length() ; j++){
                    char currentChar = subStr.charAt(j);
                    if(currentChar == aVow){
                        aFound = true;
                    } else if (currentChar == eVow) {
                        eFound = true;
                    } else if(currentChar == iVow){
                        iFound = true;
                    }else if(oVow == currentChar){
                        oFound = true;
                    } else if (uVow == currentChar){
                        uFound = true;
                    } else {
                        conCount++;
                    }
                }
                if(aFound && eFound && iFound && oFound && uFound && conCount == k){
                    resultCounter++;
                }
            }
            subStringLth++;
            if(subStringLth > word.length()){
                break;
            }
        }
        return resultCounter;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq",1));
    }
}
