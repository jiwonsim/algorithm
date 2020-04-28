class Solution {
    public int solution(int[] money) {
        int answer = 0;

        // init
        int N = money.length;

        int[] dp = new int[N];
        int[] dp2 = new int[N];

        // 0번째 집을 털었을 때
        dp[0] = money[0];
        if (N > 1) dp[1] = money[1];
        for (int i = 2; i < N - 1; i++) {
            if (i == 2) dp[i] = dp[i - 2] + money[i];
            else dp[i] = Math.max(dp[i - 2] + money[i], Math.max(dp[i - 1], dp[i - 3] + money[i]));

            answer = Math.max(answer, dp[i]);
        }

        // 0번째 집을 안 털었을 때
        dp2[0] = -1000 * 1000000; // 가장 작은 값으로 초기화
        if (N > 1) dp2[1] = money[1];
        for (int i = 2; i < N; i++) {
            if (i == 2) dp2[i] = money[i];
            else dp2[i] = Math.max(dp2[i - 2] + money[i], Math.max(dp2[i - 1], dp2[i - 3] + money[i]));

            answer = Math.max(answer, dp2[i]);
        }

        return answer;
    }
}