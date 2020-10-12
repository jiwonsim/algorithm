import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] directions;
    static ArrayList<Point> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static int[][][] towards = {
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int watch() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Point cur = list.get(i);
            tempMap[cur.r][cur.c] = cur.v;
            for (int toward : towards[cur.v-1][directions[i]]) {
                int nr = cur.r + dir[toward][0], nc = cur.c + dir[toward][1];
                while (isInRange(nr, nc) && tempMap[nr][nc] != 6) {
                    tempMap[nr][nc] = cur.v;
                    nr += dir[toward][0];
                    nc += dir[toward][1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) count+=1;
            }
        }
        return count;
    }

    static boolean isInRange(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M) return false;
        return true;
    }

    static void go(int index) {
        if (index >= list.size()) {
            answer = Math.min(watch(), answer);
            return;
        }

        for (int i = 0; i < towards[list.get(index).v-1].length; i++) {
            directions[index] = i;
            go(index+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new Point(i, j, map[i][j]));
                }
            }
        }
        directions = new int[list.size()];

        go(0);
        writer.write(answer + "\n");
        writer.flush();
    }

    static private class Point {
        int r, c, v;

        Point(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}
