import java.io.*;
import java.util.*;

class Pair {
    int rr, rc; // 빨간 공의 위치
    int br, bc; // 파란 공의 위치
    int time;

    Pair(int rr, int rc, int br, int bc, int t) {
        this.rr = rr;
        this.rc = rc;
        this.br = br;
        this.bc = bc;
        time = t;
    }

}

public class Main {
    static int R = 0, B = 1;

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        char[][] map = new char[N][M];

        int rr = -1, rc = -1, br = -1, bc = -1; // 빨간 공, 파란 공의 위치
        int hr = -1, hc = -1; // 구멍의 위치

        for (int i = 0; i < N; i++) {
            String row = reader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'R') {
                    rr = i; rc = j;
                }
                if (map[i][j] == 'B') {
                    br = i; bc = j;
                }
                if (map[i][j] == 'O') {
                    hr = i; hc = j;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1},
                {1, 0}, {-1, 0}}; // 오, 왼, 하, 상
        Queue<Pair> que = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        que.add(new Pair(rr, rc, br, bc, 0));
        visited[rr][rc][br][bc] = true;

        while (!que.isEmpty()) {
            Pair cur = que.poll();

            if (cur.rr == hr && cur.rc == hc) {
                if (cur.time > 10) writer.write("-1\n");
                else writer.write(cur.time + "\n");
                writer.flush();
                return;
            }

            // 기울인다.
            for (int[] dir : directions) {
                int[] t = {0, 0};  // 구슬들의 이동 시간
                int[] nr = {cur.rr, cur.br}, nc = {cur.rc, cur.bc}; // 구슬들의 다음 위치
                boolean[] f = {false, false}; // 구슬들이 떨어졌는지 표시

                for (int i = 0; i < 2; i++) {
                    while (isInRange(nr[i]+dir[0], nc[i]+dir[1])
                            && map[nr[i]+dir[0]][nc[i]+dir[1]] != '#') {

                        nr[i] += dir[0];
                        nc[i] += dir[1];
                        t[i] += 1;

                        if (map[nr[i]][nc[i]] == 'O') {
                            // 구멍을 만났다면, 탐색을 종료한다.
                            f[i] = true;
                            break;
                        }
                    }
                }

                if (f[B]) continue; // 파란 공이 구멍을 만났으면 탐색을 안한다.

                if (nr[R] == nr[B] && nc[R] == nc[B]) {
                    if (t[R] > t[B]) { // 빨간 공이 더 늦게 도착했다.
                        nr[R] -= dir[0];
                        nc[R] -= dir[1];
                    }
                    else { // 파란 공이 더 늦게 도착했다.
                        nr[B] -= dir[0];
                        nc[B] -= dir[1];
                    }
                }

                if (visited[nr[R]][nc[R]][nr[B]][nc[B]]) { continue; }
                visited[nr[R]][nc[R]][nr[B]][nc[B]] = true;
                que.add(new Pair(nr[R], nc[R], nr[B], nc[B], cur.time+1));
            }
        }

        writer.write("-1\n");
        writer.flush();
    }

    static boolean isInRange(int r, int c) {
        return !(r < 0 || c < 0 || r >= N || c >= M);
    }
}