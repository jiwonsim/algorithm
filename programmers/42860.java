class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int val = name.charAt(i) - 'A';

            if (val > ('Z' - 'A') / 2 + 1) {
                answer += ('Z' - 'A') - val + 1;
            }
            else {
                answer += val;
            }

            // A가 있는 경우는 0이니까 피해가야돼!
            if (val == 0) {
                int idx = i + 1;
                int cntA = 0;
                while (idx + 1 < name.length() && name.charAt(idx) == 'A') {
                    cntA++;
                    idx++;
                }

                int tmp = (i - 1) * 2 + name.length() - 1 - i - cntA;
                if (len > tmp) len = tmp;
            }
        }

        answer += len;

        return answer;
    }
}