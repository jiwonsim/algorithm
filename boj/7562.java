import java.util.*;

class Pair {
    int x, y;
    int cnt;
    Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int[] toX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] toY = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int l;
    static int[][] chess;
    static boolean[][] visited;

    public static boolean checkRange(int x, int y) {
        if (x >= 0 && x < l && y >= 0 && y < l) return true;
        return false;
    }

    public static int solve(int curX, int curY, int moveX, int moveY) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(curX, curY, 0));
        visited[curX][curY] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == moveX && p.y == moveY) return p.cnt;

            for (int i = 0; i < 8; i++) {
                int goX = toX[i] + p.x;
                int goY = toY[i] + p.y;

                if (!checkRange(goX, goY)) continue;
                if (visited[goX][goY]) continue;

                q.offer(new Pair(goX, goY, p.cnt + 1));
                visited[goX][goY] = true;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- != 0) {
            l = sc.nextInt();
            chess = new int[l][l];
            visited = new boolean[l][l];

            int curX = sc.nextInt(); int curY = sc.nextInt();
            int moveX = sc.nextInt(); int moveY = sc.nextInt();

            chess[curX][curY] = 1;
            chess[moveX][moveY] = 1;

            System.out.printf("%d\n", solve(curX, curY, moveX, moveY));
        }
    }
}