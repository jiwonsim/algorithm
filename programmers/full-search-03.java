import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<String> initTestQue() {
        Queue<String> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k) continue;
                    q.offer(String.valueOf(i * 100 + j * 10 + k));
                }
            }
        }
        return q;
    }

    public int solution(int[][] baseball) {
        int answer = 0;
        Queue<String> q = initTestQue();

        int check[] = new int[999];
        while (!q.isEmpty()) {
            String curQ = q.poll();

            for (int i = 0; i < baseball.length; i++) {
                int strike = 0, ball = 0;
                String curB = String.valueOf(baseball[i][0]);

                for (int a = 0; a < 3; a++) {
                    if (curQ.charAt(a) == curB.charAt(a)) strike++;
                    for (int b = 0; b < 3; b++) {
                        if (curB.charAt(a) == curQ.charAt(b) && curQ.charAt(a) != curB.charAt(a)) ball++;
                    }
                }

//                System.out.printf("%s vs %s : %d STRIKE %d BALL \n", curQ, curB, strike, ball);
                if (strike == baseball[i][1] && ball == baseball[i][2]) {
                    check[Integer.parseInt(curQ)]++;
                }
            }
        }

        for (int i = 123; i < check.length; i++) {
//            System.out.printf("%d : %d \n", i, check[i]);
            if (check[i] ==  baseball.length) answer++;
        }

        return answer;
    }
}
