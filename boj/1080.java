import java.util.Scanner;

public class Main {
    static int N, M;

    public static int solve(boolean[][] check) {
        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (check[i][j]) continue;
                count++;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        check[k][l] = !check[k][l];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j]) return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        char[][] A = new char[N][M];
        char[][] B = new char[N][M];

        boolean[][] check = new boolean[N][M];

        String input;
        for (int i = 0; i < N; i++) {
            input = sc.next();
            for (int j = 0; j < M; j++) {
                A[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            input = sc.next();
            for (int j = 0; j < M; j++) {
                B[i][j] = input.charAt(j);
                if (A[i][j] == B[i][j]) check[i][j] = true;
                else check[i][j] = false;
            }
        }

        System.out.printf("%d", solve(check));

    }
}