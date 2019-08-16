import java.util.*;

// 19.08.16  11:04 ~ 12:05

class Pair {
    int idx;
    int line;
    int time;

    Pair (int idx, int line, int time) {
        this.idx = idx;
        this.line = line;
        this.time = time;
    }

}

public class Main {
    static int N, k;
    static int[][] line;

    public static boolean solve () {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][2];

        q.add(new Pair(1, 0, 0));

        visited[1][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.idx > N) {
                return true;
            }


            if (p.time + 1 < p.idx + 1) {
                if (p.idx + 1 > N) {
                    q.add(new Pair(p.idx + 1, p.line, p.time + 1));
                }
                else if (!visited[p.idx + 1][p.line] && line[p.idx + 1][p.line] == 1) {
                    visited[p.idx + 1][p.line] = true;
                    q.add(new Pair(p.idx + 1, p.line, p.time + 1));
                }

            }
            if (p.time + 1 < p.idx - 1) {
                if (!visited[p.idx - 1][p.line] && line[p.idx - 1][p.line] == 1) {
                    visited[p.idx - 1][p.line] = true;
                    q.add(new Pair(p.idx - 1, p.line, p.time + 1));
                }

            }

            if (p.idx + k > N) return true;
            if (p.time + 1 < p.idx + k) {
                if (p.line == 1) {
                    if (!visited[p.idx + k][p.line - 1] && line[p.idx + k][p.line - 1] == 1) {
                        visited[p.idx + k][p.line - 1] = true;
                        q.add(new Pair(p.idx + k, p.line - 1, p.time + 1));
                    }
                }
                if (p.line == 0) {
                    if (!visited[p.idx + k][p.line + 1] && line[p.idx + k][p.line + 1] == 1) {
                        visited[p.idx + k][p.line + 1] = true;
                        q.add(new Pair(p.idx + k, p.line + 1, p.time + 1));
                    }
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        k = sc.nextInt();

        line = new int[N + 1][2];
        for (int i = 0; i < 2; i++) {
            String in = sc.next();
            for (int j = 1;  j <= N; j++) {
                line[j][i] = in.charAt(j - 1) - '0';
            }
        }

        System.out.printf("%d\n", solve() ? 1 : 0);

    }
}