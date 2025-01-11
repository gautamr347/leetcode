package org.example.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    //https://leetcode.com/problems/valid-sudoku/submissions/1502102669/?envType=study-plan-v2&envId=top-interview-150

    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<String, Set<Character>> boxMap = new HashMap<>();


        for(int i=0; i<board.length; i++){
            for(int j=0;  j < board[i].length; j++){
                char currentValue = board[i][j];
                if(currentValue == '.')continue;
                rowMap.putIfAbsent(i, new HashSet<>());
                columnMap.putIfAbsent(j, new HashSet<>());
                var boxKey = "%d %d".formatted(i/3, j/3);
                boxMap.putIfAbsent(boxKey, new HashSet<>());

                //check
                if(rowMap.get(i).contains(currentValue)) return false;
                if(columnMap.get(j).contains(currentValue)) return false;
                if(boxMap.get(boxKey).contains(currentValue)) return false;

                //add
                rowMap.get(i).add(currentValue);
                columnMap.get(j).add(currentValue);
                boxMap.get(boxKey).add(currentValue);
            }
        }
        return true;

    }

}
