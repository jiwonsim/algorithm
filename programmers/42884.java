import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        // test1
        int camera = -30001;
        int testAns1 = 0;
        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                camera = routes[i][1];
                testAns1++;
            }
        }

        // test2
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        camera = -30001;
        int testAns2 = 0;
        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][1]) {
                camera = routes[i][0];
                testAns2++;
            }
        }

        answer = Math.min(testAns1, testAns2);
        return answer;
    }
}

