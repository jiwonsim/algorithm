import java.util.*;
import java.io.*;

public class Main {

    static int MOD = 1000000;

    static long calcPeriod(long M) {
        long first = 1, second = 1;
        long period = 0;

        do {
            long temp = first;
            first = second;
            second = (temp + second) % M;
            period++;
        } while (!(first == 1 && second == 1));

        return period;
    }

    static long search(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        long first = 1;
        long second = 1;
        long third = 0;

        long period = calcPeriod(MOD);

        for (int i = 2; i < n % period; i++) {
            third = (first + second) % MOD;
            first = second % MOD;
            second = third % MOD;
        }

        return third % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long answer = search(n);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}