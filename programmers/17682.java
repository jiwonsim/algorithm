// 0827 16:10 ~ 17:00
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int[] res = new int[4];

        int idx = 1;
        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                res[idx] = res[idx] * 10 + (c - '0');
            }
            else {
                if (c >= 'A' && c <= 'Z') {
                    if (c == 'S') {
                        res[idx] = res[idx] *  1;
                    }
                    if (c == 'D') {
                        res[idx] = res[idx] * res[idx];
                    }
                    if (c == 'T') {
                        res[idx] = res[idx] * res[idx] * res[idx];
                    }
                    idx++;
                }
                else {
                    if (c == '*') {
                        for (int i = idx - 2; i < idx; i++) {
                            res[i] *= 2;
                        }
                    }
                    if (c == '#') {
                        res[idx - 1] = 0 - res[idx - 1];
                    }
                }
            }
        }

        answer = res[1] + res[2] + res[3];

        return answer;
    }
}