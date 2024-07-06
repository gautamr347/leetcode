package org.example.map;

import org.example.string.Anagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Set<Integer> indexAdded = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> currentResult = new ArrayList<>();
            if (i == strs.length - 1 && !indexAdded.contains(i)) {
                currentResult.add(strs[i]);
                break;
            }
            if (indexAdded.contains(i)) {
                continue;
            }
            var currentString = strs[i];
            indexAdded.add(i);
            currentResult.add(currentString);
            for (int j = i + 1; j < strs.length; j++) {
                var nextString = strs[j];
                if (indexAdded.contains(j)) {
                    continue;
                }
                var isAnagram = Anagram.isAnagram(currentString, nextString);
                if (isAnagram) {
                    currentResult.add(nextString);
                    indexAdded.add(j);
                }
            }
            result.add(currentResult);
        }
        return result;
    }
}
