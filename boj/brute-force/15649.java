import java.util.*;

public class Main {
    static int N, M;
    static boolean[] check;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void solve(int pat, int cur, int depth) {
        if (depth >= M) {
            for (int i = 0; i < M; i++) sb.append(ans[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (check[i]) continue;
            check[i] = true;
            ans[depth] = i;
            solve(pat, i, depth + 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        check = new boolean[N + 1];
        ans = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            check[i] = true;
            ans[0] = i;
            solve(i, 1, 1);
            check[i] = false;
        }

        System.out.printf("%s", sb);
    }
}