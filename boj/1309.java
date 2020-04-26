import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // input
        int N = Integer.parseInt(br.readLine());

        // init
        int MOD = 9901;
        int[][] dp = new int[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] % MOD + dp[i - 1][1] % MOD + dp[i - 1][2] % MOD) % MOD;
            dp[i][1] = (dp[i - 1][0] % MOD + dp[i - 1][2] % MOD) % MOD;
            dp[i][2] = (dp[i - 1][0] % MOD + dp[i - 1][1] % MOD) % MOD;
        }

        bw.write(((dp[N][0] + dp[N][1] + dp[N][2]) % MOD) + "\n");
        bw.flush();
    }
}