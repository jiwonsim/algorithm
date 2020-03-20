import java.util.*;
import java.io.*;

public class Main {

    static int[] mem = new int[31];
    static int dp(int x) {
        if (x == 0) return 1;
        if (x == 1) return 0;
        if (x == 2) return 3;

        if (mem[x] != 0) return mem[x];

        int result = 3 * dp(x - 2);
        for (int i = 3; i <= x; i++) {
            if (i % 2 == 0) result += 2 * dp(x - i);
        }

        return mem[x] = result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = dp(n);
        System.out.println(result);
    }
}