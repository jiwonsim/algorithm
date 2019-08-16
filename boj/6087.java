import java.util.*;

class Pair implements Comparable<Pair>{
    int x, y;
    int dir;
    int cnt;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Pair(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pair p) {
        return this.cnt - p.cnt;
    }
}

public class Main {

    static int W, H;
    static List<Pair> list;
    static char[][] arr;

    static int[] toX = {0, 0, 1, -1}, toY = {1, -1, 0, 0};

    public static boolean isInRange(int x, int y) {
        if (x >= 0 && x < H && y >= 0 && y < W) return true;
        return false;
    }

    static PriorityQueue<Pair> q;
    static boolean[][][] visited;

    public static int solve() {

        Pair c1 = list.get(0);

        for (int i = 0; i < 4; i++) {
            q.add(new Pair(c1.x, c1.y, i, 0));
            visited[c1.x][c1.y][i] = true;
        }


        Pair c2 = list.get(1);

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == c2.x && p.y == c2.y) {

                return p.cnt;
            }

            int goX = p.x + toX[p.dir];
            int goY = p.y + toY[p.dir];

            if (!isInRange(goX, goY)) continue;
            if (visited[goX][goY][p.dir]) continue;
            if (arr[goX][goY] == '*') continue;

            visited[goX][goY][p.dir] = true;
            if (p.dir == 0 || p.dir == 1) {
                if (!visited[goX][goY][2]) {
                    q.add(new Pair(goX, goY, 2, p.cnt + 1));
                }
                if (!visited[goX][goY][3]) {
                    q.add(new Pair(goX, goY, 3, p.cnt + 1));
                }
            }
            if (p.dir == 2 || p.dir == 3) {
                if (!visited[goX][goY][0]) {
                    q.add(new Pair(goX, goY, 0, p.cnt + 1));
                }
                if (!visited[goX][goY][1]) {
                    q.add(new Pair(goX, goY, 1, p.cnt + 1));
                }
            }

            q.add(new Pair(goX, goY, p.dir, p.cnt));
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        W = sc.nextInt();
        H = sc.nextInt();

        list = new ArrayList<>();

        arr = new char[H][W];
        for (int i = 0; i < H; i++) {
            String in = sc.next();
            for (int j = 0; j < W; j++) {
                arr[i][j] = in.charAt(j);
                if (arr[i][j] == 'C') {
                    list.add(new Pair(i, j));
                }
            }
        }

        q = new PriorityQueue<>();
        visited = new boolean[H][W][4];

        System.out.printf("%d\n", solve());

    }
}