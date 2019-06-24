
class Solution
{
    public int solution(String str)
    {
        boolean[][] table = new boolean[2500][2500];
        int len = 0;

        for (int i = 0; i < str.length(); i++) table[i][i] = true;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                len = 2;
            }
        }

        int k;
        for (int i = 3; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                k = i + j - 1;
                if (str.charAt(j) == str.charAt(k)) {
                    if (!table[j + 1][k - 1]) continue;
                    table[j][k] = true;
                    if (i > len) len = i;
                }
            }
        }
        return len;
    }
}
