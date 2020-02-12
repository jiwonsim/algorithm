import java.util.*;
import java.io.*;

public class Main {
    static int calculate(int N, int[] coins, int result) {

        int count = 0;
        int sum = result;
        for (int i = N - 1; i >= 0; i--) {
            if (sum < coins[i]) continue;

            count += sum / coins[i];
            sum %= coins[i];
        }

        return count;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");

        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        int answer = calculate(N, coins, K);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }
}