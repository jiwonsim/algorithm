import java.util.*;

class Pair {
    int x, y, val, cnt;

    Pair(int x, int y, int val, int cnt) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.cnt = cnt;
    }
}


class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];

        int[] toX = {0, 0, 1, -1};
        int[] toY = {1, -1, 0, 0};

        int areaCnt = 0, sizeMax = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue;

                areaCnt++;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j, picture[i][j], 1));

                int sizeTmp = 0;
                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    sizeTmp++;

                    for (int k = 0; k < 4; k++) {
                        int goX = toX[k] + p.x;
                        int goY = toY[k] + p.y;

                        if (goX < 0 || goY < 0 || goX >= m || goY >= n) continue;
                        if (visited[goX][goY]) continue;
                        if (picture[goX][goY] != p.val) continue;

                        visited[goX][goY] = true;
                        q.add(new Pair(goX, goY, p.val, p.cnt + 1));
                    }
                }

                sizeMax = Math.max(sizeMax, sizeTmp);
            }
        }

        return new int[] {areaCnt, --sizeMax};

    }
}