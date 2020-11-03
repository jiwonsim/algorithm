import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] map = new int[N][M];

        for (int i = 0; i < K; i++) {
            String[] point = reader.readLine().split(" ");
            int r = Integer.parseInt(point[0])-1;
            int c = Integer.parseInt(point[1])-1;

            map[r][c] = 1;
        }

        boolean[][] visited = new boolean[N][M];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxCnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) continue;
                if (visited[r][c]) continue;

                Queue<Pair> que = new LinkedList<>();

                int count = 1;
                que.add(new Pair(r, c));
                visited[r][c] = true;
                
                while (!que.isEmpty()) {
                    Pair cur = que.poll();

                    for (int[] dir : dirs) {
                        int nr = dir[0] + cur.r;
                        int nc = dir[1] + cur.c;

                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if (visited[nr][nc]) continue;
                        if (map[nr][nc] == 0) continue;

                        visited[nr][nc] = true;
                        que.add(new Pair(nr, nc));
                        count++;
                    }
                }
                
                maxCnt = Math.max(maxCnt, count);
            }
        }

        writer.write(maxCnt+ "\n");
        writer.flush();
        writer.close();
    }


    private static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
