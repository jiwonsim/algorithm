import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left = 0, right = ((long)times[times.length - 1]) * n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long customer = n;
            for (int i = 0; i < times.length; i++) {
                customer -= mid / times[i];
                if (customer < 0) break;
            }

            if (customer > 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}