import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[][] pal = new boolean[2501][2501];

        int len = s.length();
        if (len == 1) {
            System.out.printf("1");
            return;
        }
        if (len == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                System.out.printf("1");
            }
            else System.out.printf("2");
            return;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if (i == 1) pal[j][j + i] = true;
                else if (i == 2) {
                    if (s.charAt(j) == s.charAt(j + 1)) pal[j][j + i] = true;
                    else pal[j][j + i] = false;
                }
                else {
                    if (s.charAt(j) == s.charAt(j + i - 1) && pal[j + 1][j + i - 1]) {
                        pal[j][j + i] = true;
                    }
                    else pal[j][j + i] = false;
                }
            }
        }


        int[] dp = new int[2501];
        dp[0] = 0;
        dp[1] = 1;
        if (s.charAt(0) == s.charAt(1)) dp[2] = 1;
        else dp[2] = 2;
        for (int i = 3; i <= len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (pal[j][i]) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }


        System.out.printf("%d\n", dp[len]);
    }
}