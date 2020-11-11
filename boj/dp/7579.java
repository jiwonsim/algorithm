import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 100
        int M = Integer.parseInt(input[1]); // 10,000,000

        int[] m = new int[N+1]; // mi <= 10,000,000
        int[] c = new int[N+1]; // ci <= 100

        String[] inputM = reader.readLine().split(" ");
        String[] inputC = reader.readLine().split(" ");
        for (int i = 1; i <= N; i++) m[i] = Integer.parseInt(inputM[i-1]);
        for (int j = 1; j <= N; j++) c[j] = Integer.parseInt(inputC[j-1]);

        int[][] dp = new int[N+1][10000+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j >= c[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + m[i]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i <= 10000; i++) {
            if (dp[N][i] >= M) {
                answer = i;
                break;
            }
        }

        writer.write(answer + "\n");
        writer.flush();
        writer.close();
    }
}
