import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, n;
    static boolean visited[];

    public static int dp(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x == 2) return 2;
        if (x == 3) return 4;

        if (x >= 4) {
            return dp(x-1) + dp(x-2) + dp(x-3);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }
}