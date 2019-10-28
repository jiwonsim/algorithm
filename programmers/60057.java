import java.util.*;

class Solution {

    int search(String str, int strLen, int sliceLen) {

        int i = sliceLen, cnt = 1, resLen = strLen;
        String before = str.substring(0, i);
        String compressed = "";
        String cur = "";
        while (i <= strLen) {
            if (i + sliceLen > strLen) {
                cur = str.substring(i, strLen);
            }
            else cur = str.substring(i, i + sliceLen);
            if (cur.equals(before)) {
                cnt++;
            }
            else {
                if (cnt == 1) compressed += before;
                else compressed += cnt + before;
                before = cur;

                if (cur.length() < sliceLen) compressed += cur;
                cnt = 1;
            }
            i += sliceLen;
        }

        return compressed.length();

    }

    public int solution(String s) {
        int MAX = 1001;
        int n = s.length();

        if (n == 1) return 1;

        for (int i = 1; i < n; i++) {
            MAX = Math.min(search(s, n, i), MAX);
        }

        return MAX;
    }
}