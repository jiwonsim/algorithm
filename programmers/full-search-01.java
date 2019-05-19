import java.util.*;

class Solution {
    public int first(int[] answers) {
        int sel = 1, cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == sel) {
                cnt++;
            }
            sel ++;
            if (sel % 6 == 0) sel = 1;
        }
        System.out.println();
        return cnt;
    }

    public int second(int[] answers) {
        int sel = 0, before = 0, cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                sel = 2;
            }
            else {
                sel = before;
                sel++;
                if (sel == 2) sel++;
                if (sel % 6 == 0) sel = 1;
                before = sel;
            }

            if (answers[i] == sel) {
                cnt++;
            }
        }
        System.out.println();
        return cnt;
    }

    public int third(int[] answers) {
        int sel[] = {3, 1, 2, 4, 5};
        int cnt = 0, cur = -1, before = -1;
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                cur = sel[(i % 10) / 2];
                before = cur;
            }
            else {
                cur = before;
            }

            if (cur == answers[i]) {
                cnt++;
            }
        }
        System.out.println();
        return cnt;
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        list.add(0, first(answers));
        list.add(1, second(answers));
        list.add(2, third(answers));

        int MAX = Collections.max(list);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (MAX == list.get(i)) ans.add(i + 1);
        }

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}