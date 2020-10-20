import java.util.*;


class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer>[] dp = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 1; i < 9; i++) {
            StringBuffer sb = new StringBuffer(N);
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }

            dp[i].add(Integer.parseInt(sb.toString()));

            for (int j = 0; j <= i; j++) {
                int nSize = dp[j].size();
                int mSize = dp[i-j].size();

                for (int n = 0; n < nSize; n++) {
                    int k = dp[j].get(n);
                    for (int m = 0; m < mSize; m++) {
                        int l = dp[i-j].get(m);

                        dp[i].add(k + l);
                        dp[i].add(k - l);
                        dp[i].add(k * l);
                        if (l != 0) dp[i].add(k / l);
                    }
                }
            }


            if (dp[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
