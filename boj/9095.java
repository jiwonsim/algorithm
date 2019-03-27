import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
해당 문제는 두 가지로 풀 수 있다!
 */

public class Main {
    static int ele[] = {1, 2, 3};

    public static int dfs(int n, int sum) {
        if (sum == n) return 1;
        if (sum > n) return 0;

        int res = 0;
        for (int i = 0; i < ele.length; i++) {
            res += dfs(n, sum + ele[i]);
        }
        return res;
    }

    public static int dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        if (n >= 4) {
            return dp(n - 1) + dp(n - 2) + dp(n - 3);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dfs(n, 0));
//            System.out.println(dp(n));

        }
    }
}