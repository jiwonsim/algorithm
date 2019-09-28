import java.util.*;

public class Main {

    static int MAX = Integer.MIN_VALUE;

    static char[][] candies;

    static void countRightCandy(int N, int x, int y) {
        // (0, y) (0, y + 1), (x, 0)
        int cy1 = candies[0][y], cy2 = candies[0][y + 1], cx = candies[x][0];
        int cy1Cnt = 0, cy2Cnt = 0, cxCnt = 0;
        for (int i = 0; i < N; i++) {

            if (cy1 == candies[i][y]) cy1Cnt++;
            else {
                cy1 = candies[i][y];
                cy1Cnt = 1;
            }

            if (cy2 == candies[i][y + 1]) cy2Cnt++;
            else {
                cy2 = candies[i][y + 1];
                cy2Cnt = 1;
            }

            if (cx == candies[x][i]) cxCnt++;
            else {
                cx = candies[x][i];
                cxCnt = 1;
            }

            MAX = Math.max(MAX, Math.max(cy1Cnt, Math.max(cy2Cnt, cxCnt)));
        }
    }

    static void countDownCandy(int N, int x, int y) {
        // (x, 0) (x + 1, 0) (0, y)

        int cx1 = candies[x][0], cx2 = candies[x + 1][0], cy = candies[0][y];
        int cx1Cnt = 0, cx2Cnt = 0, cyCnt = 0;
        for (int i = 0; i < N; i++) {
            if (cy == candies[i][y]) cyCnt++;
            else {
                cy = candies[i][y];
                cyCnt = 1;
            }

            if (cx1 == candies[x][i]) cx1Cnt++;
            else {
                cx1 = candies[x][i];
                cx1Cnt = 1;
            }

            if (cx2 == candies[x + 1][i]) cx2Cnt++;
            else {
                cx2 = candies[x + 1][i];
                cx2Cnt = 1;
            }

            MAX = Math.max(MAX, Math.max(cx1Cnt, Math.max(cx2Cnt, cyCnt)));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        candies = new char[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            String in = sc.next();
            for (int j = 0; j < N; j++) {
                candies[i][j] = in.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char tmp;

                // (i, j) <-> (i, j + 1) swap
                if (j < N - 1) {
                    tmp = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = tmp;
                    countRightCandy(N, i, j);
                    tmp = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = tmp;
                }


                // (i, j) <-> (i + 1, j) swap
                if (i < N - 1) {
                    tmp = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = tmp;
                    countDownCandy(N, i, j);
                    tmp = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = tmp;
                }
            }
        }

        System.out.printf("%d\n", MAX);
    }
}