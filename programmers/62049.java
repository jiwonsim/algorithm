import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;

        // initialize
        StringBuilder[] sb = new StringBuilder[21];

        sb[0] = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb[i] = new StringBuilder();
            sb[i].append(sb[i - 1]);
            sb[i].append(0);
            String before = sb[i - 1].toString();
            for (int j = before.length() - 1; j >= 0; j--) {
                sb[i].append(before.charAt(j) == '1' ? '0' : '1');
            }
        }

        String ansStr = sb[n].toString();
        answer = new int[ansStr.length()];
        for (int i = 0; i < ansStr.length(); i++) {
            answer[i] = ansStr.charAt(i) - '0';
        }

        return answer;
    }
}