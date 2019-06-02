import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;

        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') list.add(arrangement.charAt(i));
            else {
                char before = arrangement.charAt(i - 1);
                list.remove(list.size() - 1);
                // ')'를 만났을 때
                if (before == '(') {
                    // 레이저
                    answer += list.size();
                }
                else {
                    // 쇠막대
                    answer += 1;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()(((()())(())()))(())"));

    }
}