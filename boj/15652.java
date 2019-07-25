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

        for (int i = cur; i <= N; i++) {
            if (pat > i) continue;
            ans[depth] = i;
            solve(pat, i, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        check = new boolean[N + 1];
        ans = new int[M];
        for (int i = 1; i <= N; i++) {
            ans[0] = i;
            solve(i, 1, 1);
        }

        System.out.printf("%s", sb);
    }
}