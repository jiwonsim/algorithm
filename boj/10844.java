import java.util.*;

public class Main {

    static long calcStairs(int N) {
        long mod = 1000000000;
        long[][] stairs = new long[101][10];

        for (int i = 1; i < 10; i++) stairs[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) stairs[i][j] = stairs[i - 1][j + 1] % mod;
                else if (j == 9) stairs[i][j] = stairs[i - 1][j - 1] % mod;
                else stairs[i][j] = stairs[i - 1][j - 1] + stairs[i - 1][j + 1] % mod;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += stairs[N][i];
        }
        return answer % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.printf("%d", calcStairs(N));
    }
}