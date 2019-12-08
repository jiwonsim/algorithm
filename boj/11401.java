import java.util.*;
import java.io.*;

public class Main {
    static long MOD = 1000000007;
    static int size = 4000000;
    static long[] factorials = new long[4000001];
    static long[] inversed = new long[4000001];

    static void initFactorial() {
        factorials[1] = 1;
        for (int i = 2; i <= size; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
        }
    }

    static long calcPower(long n, long p) {
        if (p == 0) return 1;
        if (p == 1) return n % MOD;

        if (p % 2 == 1)
            return (n * calcPower((n * n) % MOD, (p - 1) / 2)) % MOD;
        return calcPower((n * n) % MOD, p / 2) % MOD;
    }

    static void initInverse() {
        inversed[size] = calcPower(factorials[size], MOD - 2);
        for (int i = size - 1; i > 0; i--) {
            inversed[i] = (inversed[i + 1] * (i + 1)) % MOD;
        }
    }


    static long solve(int N, int K) {
        if (N == K || K == 0) {
            return 1;
        }

        return ((factorials[N] * inversed[N - K]) % MOD) * inversed[K] % MOD;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);

        initFactorial();
        initInverse();
        long answer = solve(N, K);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();

    }
}