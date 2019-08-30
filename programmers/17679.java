import java.util.*;

// 0830 14:30 ~ 16:25

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    char[][] boardArr;
    List<Pair> removeList = new ArrayList<>(); // 삭제될 인덱스 모음

    public boolean isSameSquare(int x, int y) {
        // 2x2배열이 같은 원소를 갖는지 확인
        char comp = boardArr[x][y];

        if (comp == '*') return false;

        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                if (comp != boardArr[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

    public void move(int x, int y) {
        int nextX = x;
        if (nextX + 1 >= boardArr.length || boardArr[nextX + 1][y] != '*') return;

        while (nextX + 1 < boardArr.length && boardArr[nextX + 1][y] == '*') {
            nextX++;
        }

        char tmp = boardArr[x][y];
        boardArr[x][y] = boardArr[nextX][y];
        boardArr[nextX][y] = tmp;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        boardArr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardArr[i][j] = board[i].charAt(j);
            }
        }


        while (true) {
            boolean flag = false;
            removeList = new ArrayList<>();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isSameSquare(i, j)) {
                        flag = true;
                        removeList.add(new Pair(i, j));
                    }
                }
            }

            if (!flag) break;

            for (Pair p : removeList) {
                for (int i = p.x; i < p.x + 2; i++) {
                    for (int j = p.y; j < p.y + 2; j++) {
                        if (boardArr[i][j] != '*') answer++;
                        boardArr[i][j] = '*';
                    }
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    move(i, j);
                }
            }

        }

        return answer;
    }
}