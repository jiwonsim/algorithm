import java.io.*;
import java.util.*;

class Pos {
    int l, r, c, w;

    Pos(int l, int r, int c, int w) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.w = w;
    }
}

public class Main {

    static int L, R, C;
    static char[][][] map;
    static Pos S, E;
    static int[] dirR = {0, 0, 1, -1}, dirC = {1, -1, 0, 0};

    static int search() {
        Queue<Pos> que = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];

        que.add(S);

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            if (cur.l == E.l && cur.r == E.r && cur.c == E.c) return cur.w;

            // 상하
            if (cur.l + 1 < L && map[cur.l + 1][cur.r][cur.c] != '#' && !visited[cur.l + 1][cur.r][cur.c]) {
                visited[cur.l + 1][cur.r][cur.c] = true;
                que.add(new Pos(cur.l + 1, cur.r, cur.c, cur.w + 1));
            }

            if (cur.l - 1 >= 0 && map[cur.l - 1][cur.r][cur.c] != '#' && !visited[cur.l - 1][cur.r][cur.c]) {
                visited[cur.l - 1][cur.r][cur.c] = true;
                que.add(new Pos(cur.l - 1, cur.r, cur.c, cur.w + 1));
            }

            // 동서남북
            for (int i = 0; i < 4; i++) {
                int nextR = dirR[i] + cur.r;
                int nextC = dirC[i] + cur.c;

                if (nextR >= R || nextC >= C || nextR < 0 || nextC < 0) continue;
                if (map[cur.l][nextR][nextC] == '#') continue;
                if (visited[cur.l][nextR][nextC]) continue;

                visited[cur.l][nextR][nextC] = true;
                que.add(new Pos(cur.l, nextR, nextC, cur.w + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            // input
            String[] input = br.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            if (L == R && R == C && C == 0) break;

            map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String blocks = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = blocks.charAt(k);
                        if (map[i][j][k] == 'S') S = new Pos(i, j, k, 0);
                        if (map[i][j][k] == 'E') E = new Pos(i, j ,k, 0);
                    }
                }
                br.readLine(); // blank line
            }

            int result = search();
            if (result == -1) {
                bw.write("Trapped!\n");
            }
            else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
            bw.flush();
        }

        bw.close();
    }
}