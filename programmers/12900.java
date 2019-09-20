class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] cnt = new int[60000];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) cnt[i] = i;
            else {
                cnt[i] = (cnt[i - 2] + cnt[i - 1]) % 1000000007;
            }
        }

        return cnt[n];
    }
}