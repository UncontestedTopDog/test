package com.yy.android.leetcode;

import java.util.HashSet;
import java.util.Set;

class LeetCode36 {

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            set2.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (set2.contains(board[j][i])) {
                        return false;
                    }
                    set2.add(board[j][i]);
                }
            }
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                set.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[3*x+i][3*y+j] == '.') {
                            continue;
                        }
                        if (set.contains(board[3*x+i][3*y+j])) {
                            return false;
                        }
                        set.add(board[3*x+i][3*y+j]);
                    }
                }
            }
        }
        return true;
    }
}
