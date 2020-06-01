import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static final int[] toRow = {0, 0, 1, -1}, toCol = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                visited = new boolean[N][M];
                dist = new int[N][M];

                if (search(i, j, 0, map[i][j])) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static boolean search(int row, int col, int cnt, char value) {
        if (visited[row][col]) {
            return cnt - dist[row][col] >= 4;
        }

        visited[row][col] = true;
        dist[row][col] = cnt;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + toRow[i];
            int nextCol = col + toCol[i];

            if (!isInRange(nextRow, nextCol)) continue;
            if (map[nextRow][nextCol] != value) continue;

            if (search(nextRow, nextCol, cnt + 1, value))
                return true;
        }

        return false;
    }

    static boolean isInRange(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M) return false;
        return true;
    }
}