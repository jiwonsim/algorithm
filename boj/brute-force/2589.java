import java.util.*;
import java.io.*;

public class Main {

    /*
    보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
    육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
     */
    static int[][] dirs = {{-1, 0}, {1, 0},
                            {0, -1}, {0, 1}};

    static int N, M;
    static char[][] map;
    static ArrayList<Pair> lands;

    static boolean isInRange(Pair p) {
        if (p.r < 0 || p.c < 0 || p.r >= N || p.c >= M) return false;
        if (map[p.r][p.c] == 'W') return false;
        return true;
    }

    static int bfs(Pair start) {
        int[][] dist = new int[N][M];
        Queue<Pair> que = new LinkedList<>();

        que.add(start);
        dist[start.r][start.c] = 1;

        while (!que.isEmpty()) {
            Pair cur = que.poll();

            for (int[] dir : dirs) {
                Pair next = new Pair(dir[0]+cur.r, dir[1]+cur.c);

                if (!isInRange(next)) continue;
                if (dist[next.r][next.c] > 0) continue;

                dist[next.r][next.c] = dist[cur.r][cur.c]+1;
                que.add(next);
            }

        }
        return maxDist(dist);
    }

    static int maxDist(int[][] dist) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(dist[i][j], max);
            }
        }
        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = reader.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new char[N][M];
        lands = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'L') lands.add(new Pair(i, j));
            }
        }

        int answer = 0;

        for (Pair land : lands) {
            answer = Math.max(answer, bfs(land));

        }

        writer.write(answer + "\n");
        writer.flush();
    }

    private static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
