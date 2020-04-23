import java.util.*;
import java.io.*;

public class Main {
    static int SIZE = 1000001;
    static boolean[] prime = new boolean[SIZE];

    static void initPrime() {
        Arrays.fill(prime, true);

        for (int i = 2; i * i < SIZE; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j < SIZE; j += i) {
                prime[j] = false;
            }
        }
    }

    static int goldbach(int num) {
        int count = 0;
        for (int i = 2; i <= num / 2; i++) {
            if (!prime[i] || !prime[num - i]) continue;
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initPrime();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write(goldbach(Integer.parseInt(br.readLine())) + "\n") ;
            bw.flush();
        }
    }
}