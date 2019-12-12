import java.util.*;
import java.io.*;

public class Main {
    static long fibonacci(int n) {
        if (n == 0) return 1;
        if (n <= 2) return 1;

        long first = 1;
        long second = 1;
        long third = 0;

        for (int i = 2; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long answer = fibonacci(n);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}