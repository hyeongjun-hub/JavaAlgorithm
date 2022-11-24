package programmers_kakao.행렬과연산;

import java.util.ArrayDeque;
import java.util.LinkedList;

class Solution {
    int r,c;
    ArrayDeque<Integer> col1, col2;
    LinkedList<ArrayDeque<Integer>> rows;

    public void init(int[][] rc) {
        r = rc.length;
        c = rc[0].length;

        col1 = new ArrayDeque<>();
        col2 = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            col1.add(rc[i][0]);
            col2.add(rc[i][c - 1]);
        }
        rows = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            ArrayDeque<Integer> row = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++) {
                row.add(rc[i][j]);
            }
            rows.add(row);
        }
    }

    public int[][] getAnswer(){
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            ans[i][0] = col1.pollFirst();
            ans[i][c - 1] = col2.pollFirst();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c - 1; j++) {
                ans[i][j] = rows.get(i).pollFirst();
            }
        }
        return ans;
    }

    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);
        for (String operation : operations) {
            if(operation.startsWith("R")) rotate();
            else shiftRow();
        }
        return getAnswer();
    }

    public void shiftRow() {
        rows.addFirst(rows.pollLast());
        col1.addFirst(col1.pollLast());
        col2.addFirst(col2.pollLast());
    }

    public void rotate() {
        if (c == 2) {
            col2.addFirst(col1.pollFirst());
            col1.addLast(col2.pollLast());
            return;
        }
        rows.peekFirst().addFirst(col1.pollFirst());
        col2.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(col2.pollLast());
        col1.addLast(rows.peekLast().pollFirst());
    }
}