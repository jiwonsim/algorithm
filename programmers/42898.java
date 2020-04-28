class Solution {
    public int solution(int m, int n, int[][] puddles) {

        // init
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        dp[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) dp[i][j] = 0;
                else {
                    dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}