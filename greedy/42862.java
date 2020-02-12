import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] status = new int[n + 1];
        Arrays.fill(status, 0);

        for (int resEle : reserve) {
            status[resEle]++;
        }

        for (int lostEle : lost) {
            status[lostEle]--;
        }

        for (int i = 1; i <= n; i++) {
            if (status[i] == -1) {
                if (i == 1 || i < n) {
                    if (status[i + 1] > 0) {
                        status[i]++;
                        status[i + 1]--;
                        continue;
                    }
                }
                if (i == n || i > 1) {
                    if (status[i - 1] > 0) {
                        status[i]++;
                        status[i - 1]--;
                        continue;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (status[i] != -1) answer++;
        }

        return answer;
    }
}