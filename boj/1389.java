import java.util.*;

public class Main {
    static int[][] frd;
    static int N, M;

    public static int solve(int idx) {
        Queue<Integer> q = new LinkedList<>();
        int depth = 0;
        q.offer(idx);
        boolean visited[] = new boolean[N];
        int count[] = new int[N];
        while (!q.isEmpty()) {
            int cur = q.poll();

            depth = count[cur] + 1;

            for (int i = 0; i < N; i++) {
                if (cur == i) continue;
                if (visited[i]) continue;
                if (frd[cur][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                    count[i] = depth;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (idx == i) {
                continue;
            }


            sum += count[i];
        }


        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        frd = new int[N][N];
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            n1--; n2--;
            frd[n1][n2] = 1;
            frd[n2][n1] = 1;
        }

        int res = 0, MAX = Integer.MAX_VALUE;
        int id = 0;

        for (int i = 0; i < N; i++) {
            res = solve(i);
            if (MAX > res) {
                MAX = res;
                id = i;
            }
        }

        System.out.printf("%d\n", id + 1);
    }
}