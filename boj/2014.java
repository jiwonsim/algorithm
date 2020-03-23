import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static long[] primes;

    static long find(int N) {
        for (int i = 0; i < primes.length; i++) {
            pq.add(primes[i]);
        }

        long cur = 0;
        for (int i = 0; i < N; i++) {
            cur = pq.poll();

            for (int j = 0; j < primes.length; j++) {
                long next = primes[j] * cur;
                pq.add(next);

                if (cur % primes[j] == 0) break;
            }
        }
        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        primes = new long[K];
        for (int i = 0; i < K; i++) {
            primes[i] = Integer.parseInt(input[i]);
        }

        long result = find(N);
        System.out.println(result);

    }
}