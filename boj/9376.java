import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int h, w;
    static char[][] arr;
    static Deque<Pair> prs;

    static int[] toX = {1, -1, 0, 0};
    static int[] toY = {0, 0, 1, -1};

    public static boolean isInRange(int x, int y) {
        if (x >= 0 && x < h + 2 && y >= 0 && y < w + 2) return true;
        return false;
    }

    public static int[][] solve(int x, int y) {
        int[][] cnt = new int[h + 2][w + 2];

        // init array
        for (int i = 0; i < h + 2; i++) {
            for (int j = 0; j < w + 2; j++) {
                cnt[i][j] = -1;
            }
        }

        Deque<Pair> dq = new ArrayDeque<>();

        dq.addFirst(new Pair(x, y));
        cnt[x][y] = 0;

        while (!dq.isEmpty()) {
            Pair cur = dq.remove();

            for (int i = 0; i < 4; i++) {
                int goX = toX[i] + cur.x;
                int goY = toY[i] + cur.y;

                if (!isInRange(goX, goY)) continue;
                if (arr[goX][goY] == '*') continue;
                if (cnt[goX][goY] != -1) continue;
                if (arr[goX][goY] == '#') {
                    cnt[goX][goY] = cnt[cur.x][cur.y] + 1;
                    dq.addLast(new Pair(goX, goY));
                }
                else {
                    cnt[goX][goY] = cnt[cur.x][cur.y];
                    dq.addFirst(new Pair(goX, goY));
                }

            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            h = sc.nextInt();
            w = sc.nextInt();

            arr = new char[h + 2][w + 2];
            prs = new ArrayDeque<>();

            prs.addLast(new Pair(0, 0));
            for (int i = 1; i < h + 1; i++) {
                String in = sc.next();
                for (int j = 1; j < w + 1; j++) {
                    arr[i][j] = in.charAt(j - 1);
                    if (arr[i][j] == '$') {
                        prs.addLast(new Pair(i, j));
                    }
                }
            }

            int[][] sum = new int[h + 2][w + 2];
            while (!prs.isEmpty()) {
                Pair p = prs.remove();

                int[][] tmp = solve(p.x, p.y);
                for (int n = 0; n < h + 2; n++) {
                    for (int m = 0; m < w + 2; m++) {
                        sum[n][m] += tmp[n][m];
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    if (arr[i][j] == '*') continue;
                    if (arr[i][j] == '#') {
                        sum[i][j] -= 2;
                    }
                    if (sum[i][j] < res) {
                        res = sum[i][j];
                    }
                }
            }

            System.out.printf("%d\n", res);

        }
    }
}