import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // init
        int[] array = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        Arrays.fill(dp, 1);
        int MAX = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] >= array[j]) continue;
                dp[i] = Math.max(dp[j] + 1, dp[i]);
                MAX = Math.max(dp[i], MAX);
            }
        }

        bw.write(MAX + "\n");
        bw.flush();
    }
}