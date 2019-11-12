import java.util.*;

public class Main {

    static int N, M;
    static char[][] chess;

    static int search(int y, int x, char comp) {

        // 맨 왼쪽 위 칸이 흰색인 경우
        int result = 0;
        for (int i = y; i < y + 8; i++) {
            if (comp != chess[i][x]) result++;

            for (int j = x + 1; j < x + 8; j++) {
                if (comp == chess[i][j]) {
                    result++;

                    comp = comp == 'W' ? 'B' : 'W';
                }
                else {
                    comp = chess[i][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        chess = new char[N][M];
        for (int i = 0; i < N; i++) {
            String in = sc.next();
            for (int j = 0; j< M; j++) {
                chess[i][j] = in.charAt(j);
            }
        }

        int MIN = N * M + 1;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                MIN = Math.min(MIN, Math.min(search(i, j, 'W'), search(i, j, 'B')));
            }
        }


        System.out.printf("%d", MIN);
    }
}