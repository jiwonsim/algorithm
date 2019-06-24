// 참고사이트 : https://www.mstst33.com/programmers-the_longest_palindrome/201/


class Solution
{
    public boolean isPalindrome(String str, int start, int end) {
        if (start == end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    public int solution(String s)
    {
        boolean[][] arr = new boolean[2500][2500];


        for (int i = 0; i < s.length(); i++) arr[i][i] = true;

        int len = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                arr[i][i + 1] = true;
                len = 2;
            }
        }

        int k;
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j <= (s.length() - i); j++) {
                k = i + j - 1;
                if (arr[j + 1][k - 1] && s.charAt(j) == s.charAt(k)) {
                    arr[j][k] = true;
                    if (i > len) len = i;
                }
            }
        }

        return len;
    }
}
