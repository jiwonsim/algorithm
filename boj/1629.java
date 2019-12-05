import java.util.*;
import java.io.*;

public class Main {
    static int A, B, C;

    static long calc(long n, long p) {
        if (p == 0) return 1;
        if (p == 1) return n % C;

        if (p % 2 == 1) return (n * calc((n * n) % C, (p - 1) / 2)) % C;
        return calc((n * n) % C, p / 2) % C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        A = Integer.parseInt(nums[0]);
        B = Integer.parseInt(nums[1]);
        C = Integer.parseInt(nums[2]);

        bw.write(calc(A, B) + "\n");
        bw.flush();
        bw.close();
    }
}