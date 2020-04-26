import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // input
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[3][N + 1];
            for (int i = 1; i <= 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(input[j]);
                }
            }

            // calculate & output
            bw.write(calculate(sticker, N) + "\n");
            bw.flush();
        }
    }

    static int calculate(int[][] sticker, int N) {
        // init dp
        int[][] dp = new int[3][N + 1];
        dp[0][0] = 0;
        dp[1][0] = sticker[1][0];
        dp[2][0] = sticker[2][0];

        // calculate
        for (int i = 1; i <= N; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + sticker[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + sticker[1][i];
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + sticker[2][i];
        }

        // output
        return Math.max(dp[0][N], Math.max(dp[1][N], dp[2][N]));
    }

}