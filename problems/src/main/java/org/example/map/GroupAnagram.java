package org.example.map;

import org.example.string.Anagram;

import java.util.*;

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

    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            var strArray = str.toCharArray();
            Arrays.sort(strArray);
            if (anagramMap.containsKey(new String(strArray))) {
                anagramMap.get(new String(strArray)).add(str);
            } else {
                List<String> tempSet = new ArrayList<>();
                tempSet.add(str);
                anagramMap.put(new String(strArray), tempSet);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
