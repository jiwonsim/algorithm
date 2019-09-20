import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int n = citations.length;
        int max = citations[n - 1];

        for (int h = max; h >= 0; h--) {
            int quot = 0, notQuot = 0;
            for (int j = 0; j < n; j++) {
                if (h <= citations[j]) quot++;
                if (h >= citations[j]) notQuot++;
            }

            if (h <= quot && h >= notQuot) {
                return h;
            }
        }

        return answer;
    }
}