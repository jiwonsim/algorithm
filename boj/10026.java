import java.util.*;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[][] arr;
    static int cnt;
    static int[] goX = {0, 0, 1, -1};
    static int[] goY = {1, -1, 0, 0};

    public static boolean isInRange(int x, int y) {
        if (x >= N || x < 0 || y >= N || y < 0) return false;
        return true;
    }

    // BFS
//    public static int color(int x, int y) {
//        cnt = 0;
//        boolean[][] check = new boolean[N][N];
//        Queue<Pair> cq = new LinkedList<>();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (check[i][j]) continue;
//
//                check[i][j] = true;
//                cq.offer(new Pair(i, j));
//
//                while (!cq.isEmpty()) {
//                    Pair cur = cq.poll();
//
////                    System.out.printf("%d %d\n", cur.x, cur.y);
//
//                    for (int k = 0; k < 4; k++) {
//                        int toX = cur.x + goX[k];
//                        int toY = cur.y + goY[k];
//
//                        if (!isInRange(toX, toY)) continue;
//                        if (arr[toX][toY] != arr[cur.x][cur.y]) continue;
//                        if (check[toX][toY]) continue;
//
//                        check[toX][toY] = true;
//                        cq.offer(new Pair(toX, toY));
//                    }
//                }
//                cnt++;
////                System.out.printf("\n");
//            }
//        }
//
//        return cnt;
//    }


    // DFS
    static boolean[][] check;
    public static int color(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int toX = x + goX[i];
            int toY = y + goY[i];

            if (!isInRange(toX, toY)) continue;
            if (check[toX][toY]) continue;
            if (arr[x][y] != arr[toX][toY]) continue;

            check[toX][toY] = true;
            color(toX, toY);
        }


        return 0;
    }

    public static int solve() {

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j]) continue;
                cnt++;
                color(i, j);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];

        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'R') arr[i][j] = 0;
                else if (str.charAt(j) == 'G') arr[i][j] = 1;
                else arr[i][j] = 2;
            }
        }

        System.out.printf("%d ", solve());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) arr[i][j] = 0;
            }
        }
        check = new boolean[N][N];
        System.out.printf("%d\n", solve());

//        System.out.printf("%d ", color(0, 0));
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (arr[i][j] == 1) arr[i][j] = 0;
//            }
//        }
//
//        System.out.printf("%d\n", color(0, 0));
    }
}