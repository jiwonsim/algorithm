import java.util.*;
import java.io.*;

public class Main {
    static long waves(int N) {

        if (N <= 3) return 1;

        long first = 1;
        long second = 1;
        long third = 1;

        long result = 0;

        for (int i = 2; i < N - 1; i++) {
            result = first + second;
            first = second;
            second = third;
            third = result;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long answer = waves(N);
            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
    }
}