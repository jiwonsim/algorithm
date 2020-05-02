
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");

            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int result = search(M, N, x, y, lcm(M, N));

            bw.write(result + "\n");
            bw.flush();
        }
    }

    static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    static int search(int M, int N, int x, int y, int MAX) {
        int count = 0;
        int i = M * count + x;

        for (; i <= MAX;) {
            int remX = i % M;
            int remY = i % N;

            if (remX == 0) remX = M;
            if (remY == 0) remY = N;

            if (remX == x && remY == y) return i;

            count++;
            i = M * count + x;
        }
        return -1;
    }
}