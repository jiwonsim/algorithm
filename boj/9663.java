import java.util.*;

// hint : 유망한 노드들만 검사하고 유망하지 않다면 부모 노드로 돌아가 탐색을 계속한다.

public class Main {
    static int N, res;
    static int[] col;
    public static void solve(int row) {
        if (row == N) {
            res++; // 끝
        }
        else {
            for (int i = 1; i <= N; i++) {
                col[row + 1] = i; // i행의 row + 1열
                if (isPossible(row + 1)) {
                    solve(row + 1);
                } else {
                    col[row + 1] = 0;
                }
            }
        }
        col[row] = 0; // 초기화
    }

    public static boolean isPossible(int c) {
        for (int i = 1; i < c; i++) {
            if (col[i] == col[c]) return false;
            if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            col = new int[N + 1];
            col[1] = i; // 1행 1열, 2행 1열, 3행 1열 ... 순으로 DFS 돌리기
            solve(1);
        }

        System.out.printf("%d", res);
    }
}