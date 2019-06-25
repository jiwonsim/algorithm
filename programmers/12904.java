
class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        boolean[][] arr = new boolean[2500][2500];
        for (int i = 0; i < s.length(); i++) arr[i][i] = true;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                arr[i][i + 1] = true;
                answer = 2;
            }
        }

        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j <= (s.length() - i); j++) {
                int k = i + j - 1; // 끝 인덱스
                if (s.charAt(j) == s.charAt(k)) {
                    if (!arr[j + 1][k - 1]) continue;
                    arr[j][k] = true;
                    if (i > answer) answer = i;
                }
            }
        }

        return answer;
    }
}