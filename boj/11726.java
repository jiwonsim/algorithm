import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cache[];

    public static int dp(int N) {
        if (N == 1) return 1;
        if (cache[N] > 0) return cache[N];

        for (int i = 0; i <= N; i++) {
            if (i <= 2) cache[i] = i;
            else {
                cache[N] = dp(N - 2) + dp(N - 1);
                cache[N] %= 10007;
            }

        }
        return cache[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N+1];
        System.out.println(dp(N));
    }
}