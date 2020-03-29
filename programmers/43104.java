class Solution {
    public long solution(int N) {
        long answer = 0;

        long[] tileSize = new long[N + 1];
        tileSize[1] = 1;
        tileSize[2] = 1;
        for (int i = 3; i <= N; i++) {
            tileSize[i] = tileSize[i - 1] + tileSize[i - 2];
        }

        answer = (tileSize[N] * 2 + tileSize[N - 1]) * 2;

        return answer;
    }
}