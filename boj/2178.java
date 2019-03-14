import java.util.*;

class Point {
    int x, y, depth;
    Point (int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Main {
    static int N, M;
    static int arr[][];
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};

    static ArrayList<Integer> list = new ArrayList<>();


    public static boolean checkRange(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) return true;
        else return false;
    }

    public static void bfs(Point p) {
        int visited[][] = new int[N][M];
        Queue<Point> q = new LinkedList<>();

        q.offer(p);
        visited[p.x][p.y] = 1;

        while (!q.isEmpty()) {
            Point next = q.poll();

            if (next.x == N-1 && next.y == M-1) {
                System.out.println(next.depth);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int goX = next.x + toX[i];
                int goY = next.y + toY[i];

                if (checkRange(goX, goY) && arr[goX][goY] == 1 && visited[goX][goY] == 0) {
                    q.offer(new Point(goX, goY, next.depth+1));
                    visited[goX][goY] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        String input;
        for (int i = 0; i < N; i++) {
            input = sc.next();

            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - 48;
            }
        }

        bfs(new Point(0, 0, 1));
    }
}