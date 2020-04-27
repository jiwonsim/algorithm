import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        // init
        int[][] dp = new int[N][3];

        // calculate
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[0][j] = cost[0][j];
                else dp[0][j] = 1000 * 1000;
            }

            for (int k = 1; k < N; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + cost[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + cost[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + cost[k][2];
            }

            for (int color = 0; color < 3; color++) {
                if (color == i) continue;
                MIN = Math.min(dp[N - 1][color], MIN);
            }
        }

        // output
        bw.write(MIN + "\n");
        bw.flush();
    }
}