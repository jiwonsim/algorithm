import java.util.*;

class Solution {

    public int solution(int[] budgets, int M) {
        int len = budgets.length;
        long sum = 0;

        Arrays.sort(budgets);

        if (budgets[0] > M / len) return M / len;

        for (int i = 0; i < len; i++) sum += budgets[i];
        if (sum < M) {
            return budgets[len - 1];
        }

        int left = budgets[0], right = budgets[len - 1];
        int compMid = 0;
        while (true) {
            int mid = (left + right) / 2;

            if (mid == compMid) break;

            sum = 0;
            for (int i = 0; i < len; i++) {
                if (mid > budgets[i]) sum += budgets[i];
                else sum += mid;
            }


            if (sum > M) {
                right = mid;
            }
            else {
                left = mid;
            }

            compMid = mid;
        }

        return compMid;
    }
}