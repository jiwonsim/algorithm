import java.util.*;

class Solution {
    boolean isCorrect(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '(') st.push(cur);
            else {
                if (st.empty()) return false;
                st.pop();
            }
        }

        if (st.size() == 0) return true;
        else return false;
    }

    String[] sliceInBalance(String w) {
        int wLen = w.length();
        String[] res = new String[2];
        int left = 0, right = 0;
        String u = "", v = "";

        for (int i = 0; i < wLen; i++) {
            char cur = w.charAt(i);

            if (cur == '(') left++;
            else right++;
            u += cur;

            if (left == right) {
                v = w.substring(i + 1, wLen);
                break;
            }
        }

        res[0] = u;
        res[1] = v;

        return res;
    }

    String modifiedU(String u) {
        String slicedU, resultU = "";
        slicedU = u.substring(1, u.length() - 1);
        for (int i = 0; i < slicedU.length(); i++) {
            if (slicedU.charAt(i) == ')') resultU += '(';
            else resultU += ')';
        }

        return resultU;
    }

    String search(String p) {
        if (p.length() == 0) return "";

        String[] uv = sliceInBalance(p);
        String u = uv[0], v = uv[1], result;
        if (isCorrect(u)) {
            v = search(v);
            result = u + v;
        }
        else {
            result = "(" + search(v) + ")" + modifiedU(u);
        }

        return result;
    }


    public String solution(String p) {
        String answer = search(p);

        return answer;
    }
}