import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] map;
    static int[] move = {0, 0, 1, -1};
    static ArrayList<Pair> ripeList;
    static int unripeCnt;

    static class Pair {
        int x, y, count;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < ripeList.size(); i++) {
            queue.add(new Pair(ripeList.get(i).x, ripeList.get(i).y, 0));
            visited[ripeList.get(i).x][ripeList.get(i).y] = true;
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (map[cur.x][cur.y] == 0) unripeCnt--;

            if (unripeCnt == 0) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + move[i];
                int nextY = cur.y + move[3 - i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;

                if (map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY, cur.count + 1));
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");

        M = Integer.parseInt(NM[0]);
        N = Integer.parseInt(NM[1]);

        map = new int[N][M];

        ripeList = new ArrayList<>();
        unripeCnt = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    ripeList.add(new Pair(i, j));
                }
                else if (map[i][j] == 0) {
                    unripeCnt++;
                }
            }
        }

        int answer = bfs();
        System.out.println(answer);

    }
}