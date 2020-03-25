import java.util.*;
import java.io.*;

public class Main {
    static String first, second;
    static int[][] dp = new int[1001][1001];

    static int initDP() {
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[first.length()][second.length()];
    }

    static String backtracking() {
        ArrayList<Character> temp = new ArrayList<>();
        int n = second.length(), m = first.length();

        int j = n;
        for (int i = m; i > 0; i--) {
            while (j > 0 && dp[i][j] == dp[i][j - 1]) {
                j--;
            }

            if (dp[i][j] != dp[i - 1][j]) temp.add(second.charAt(j - 1));
        }

        StringBuffer result = new StringBuffer();
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.append(temp.get(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        first = sc.nextLine();
        second = sc.nextLine();

        int count = initDP();
        String result = backtracking();
        System.out.printf("%d\n%s\n", count, result);
    }
}