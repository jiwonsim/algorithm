import java.util.*;

public class Main {
    static int M, N;
    static int[][] map, dp;
    static int[] toX = {0, 0, 1, -1}, toY = {1, -1, 0, 0};

    static boolean isInRange(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) return false;
        return true;
    }

    static int move(int x, int y) {

        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        if (dp[x][y] == -1) dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + toX[i];
            int nextY = y + toY[i];

            if (!isInRange(nextX, nextY)) continue;
            if (map[nextX][nextY] < map[x][y]) {
                dp[x][y] += move(nextX, nextY);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
                map[i][j] = sc.nextInt();
            }
        }

        int answer = move(0, 0);
        System.out.printf("%d", answer);
    }
}