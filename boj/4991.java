import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int w, h;
    static char[][] arr;
    static int[] toX = {1, -1, 0, 0}, toY = {0, 0, 1, -1};
    static List<Pair> list = new ArrayList<>();
    static int[][] d,  dist;

    public static boolean isInRange(int x, int y) {
        if (x >= 0 && x < h && y >= 0 && y < w) return true;
        return false;
    }

    public static int[][] bfs(Pair start) {

        for (int i = 0; i < h; i++) {
            for (int j = 0;j < w; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(start);
        d[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int goX = toX[i] + p.x;
                int goY = toY[i] + p.y;

                if (!isInRange(goX, goY)) continue;
                if (arr[goX][goY] == 'x') continue;
                if (d[goX][goY] <= d[p.x][p.y] + 1) continue;

                d[goX][goY] = d[p.x][p.y] + 1;
                q.add(new Pair(goX, goY));
            }
        }

        return d;

    }

    static boolean[] visited;
    static int res;


    public static void dfs(int cur, int idx, int sum) {
        if (idx == list.size() - 1) {
            if (res > sum) {
                res = sum;
            }
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i, idx + 1, sum + dist[cur][i]);
            visited[i] = false;

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) return;

            arr = new char[h][w];
            d = new int[h][w];

            list = new ArrayList<>();


            for (int i = 0; i < h; i++) {
                String in = sc.next();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = in.charAt(j);
                    if (arr[i][j] == '*') {
                        list.add(new Pair(i, j));
                    }
                    if (arr[i][j] == 'o') {
                        list.add(0, new Pair(i, j));
                    }
                }
            }

            dist = new int[list.size()][list.size()];
            for (int i = 0; i < list.size(); i++) {
                int[][] tmp = bfs(list.get(i));

                for (int j = 0; j < list.size(); j++) {
                    Pair comp = list.get(j);
                    dist[i][j] = tmp[comp.x][comp.y];
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        dist[i][j] = -1;
                    }
                }
            }


            res = Integer.MAX_VALUE;
            visited = new boolean[list.size()];
            visited[0] = true;
            dfs(0, 0, 0);

            System.out.printf("%d\n", res);
        }

    }
}