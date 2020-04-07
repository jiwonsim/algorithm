import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int r, c, w;

    Pair(int r, int c, int w) {
        this.r = r;
        this.c = c;
        this.w  = w;
    }

    @Override
    public int compareTo(Pair target) {
        return this.w - target.w;
    }
}

public class Main {
    static int INF = 100000000;

    static int find(int N, int[][] map) {

        // 초기화
        int[][] dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dis[i][j] = INF;
            }
        }

        int[] dirR = {1, -1, 0, 0}, dirC = {0, 0, 1, -1};
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dis[0][0] = map[0][0];
        pq.add(new Pair(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = dirR[i] + cur.r;
                int nextCol = dirC[i] + cur.c;

                if (nextRow >= N || nextCol >= N || nextRow < 0 || nextCol < 0) continue;
                if (dis[cur.r][cur.c] + map[nextRow][nextCol] >= dis[nextRow][nextCol])
                    continue;

                dis[nextRow][nextCol] = dis[cur.r][cur.c] + map[nextRow][nextCol];
                pq.add(new Pair(nextRow, nextCol, map[nextRow][nextCol]));
            }
        }

        return dis[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int result = find(N, map);
            bw.write("Problem " + order++ + ": " + result + "\n");
            bw.flush();
        }

        bw.close();

    }
}