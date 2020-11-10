import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[N+1][K+1];

        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for (int i = 1; i <= N; i++) {
            input = reader.readLine().split(" ");

            w[i] = Integer.parseInt(input[0]);
            v[i] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i],
                            dp[i-1][j]);
                }
            }
        }
        
        writer.write(dp[N][K] + "\n");
        writer.flush();
        writer.close();
    }
}
