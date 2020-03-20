import java.util.*;
import java.io.*;

public class Main {
    static long[][] mem = new long[1000001][2];
    static long dp(int x) {
        mem[0][0] = 0;
        mem[1][0] = 2;
        mem[2][0] = 7;
        mem[2][1] = 1;

        for (int i = 3; i <= x; i++) {
            mem[i][1] = (mem[i - 1][1] + mem[i - 3][0]) % 1000000007;
            mem[i][0] = (3 * mem[i - 2][0] + 2 * mem[i - 1][0] + 2 * mem[i][1]) % 1000000007;
        }

        return mem[x][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(dp(N));
    }
}