package org.example.string;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> str1Count = new HashMap<>();
        Map<Character, Integer> str2Count = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            str1Count.merge(str1.charAt(i), 1, Integer::sum);
            str2Count.merge(str2.charAt(i), 1, Integer::sum);
        }
        if (str1Count.size() != str2Count.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : str1Count.entrySet()) {
            if (!Objects.equals(str2Count.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramBySorting(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        var str1Arr = str1.toCharArray();
        var str2Arr = str2.toCharArray();
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        return new String(str1Arr).equals(new String(str2Arr));
    }
}
