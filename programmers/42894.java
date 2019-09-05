import java.util.*;

class Solution {
    int[][] tmpBoard;

    boolean canFill(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (tmpBoard[i][y] != 0) return false;
        }
        return true;
    }

    boolean isBlock2Remove(int x, int y, int row, int col) {
        int emptyCnt = 0, preVal = -1;
        for (int i = x; i < x + row; i++) {
            for (int j = y; j < y + col; j++) {
                if (tmpBoard[i][j] == 0) {
                    if (!canFill(i, j)) return false;
                    if (++emptyCnt > 2) return false;
                }
                else {
                    if (preVal != -1 && preVal != tmpBoard[i][j]) return false;
                    preVal = tmpBoard[i][j];
                }
            }
        }

        for (int i = x; i < x + row; i++) {
            for (int j = y; j < y + col; j++) {
                tmpBoard[i][j] = 0;
            }
        }

        return true;
    }

    public int solution(int[][] board) {
        int answer = 0;

        tmpBoard = board;
        int cnt = 0;
        do {
            cnt = 0;
            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if (i < board.length - 1 && j < board[0].length - 2 && isBlock2Remove(i, j, 2, 3)) cnt++;
                    if (i < board.length - 2 && j < board[0].length - 1 && isBlock2Remove(i, j, 3, 2)) cnt++;
                }
            }
            answer += cnt;
        } while (cnt != 0);

        return answer;
    }
}