import java.util.*;

public class Main {

    static int n, p1, p2;
    static int[][] chon;

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n + 1];
        q.offer(p1);
        visited[p1] = true;

        int[] cnt = new int[n + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == p2) break;

            for (int i = 1; i <= n; i++) {

                if (cur == i) continue;
                if (visited[i]) continue;

                if (chon[cur][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                    cnt[i] = cnt[cur] + 1;
                }

            }
        }

        System.out.printf("%d\n", cnt[p2] == 0 ? -1 : cnt[p2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();

        chon = new int[n + 1][n + 1];
        int t = sc.nextInt();
        for (int i  = 0; i < t; i++) {
            int par = sc.nextInt();
            int chi = sc.nextInt();

            chon[par][chi] = 1;
            chon[chi][par] = 1;
        }

        solve();
    }
}