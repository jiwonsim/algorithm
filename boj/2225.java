import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] dp = new long[K + 1][N + 1];
        int MOD = 1000000000;

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 || j == 1) dp[i][j] = i;
                else {
                    dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
                }
            }
        }

        bw.write(dp[K][N] + "\n");
        bw.flush();
    }
}