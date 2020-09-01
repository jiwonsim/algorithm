import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x, y, count;
    boolean broken;

    Pair(int x, int y, int count, boolean broken) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.broken = broken;
    }

}

public class Main {
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};

    public static int moving_demo (int n, int m, int arr[][]) {
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][][] = new boolean[n][m][2];
        int STREET = 0, WALL = 1;
        q.offer(new Pair(0, 0, 1, false));
        visited[0][0][0] = true;


        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                return p.count;
            }

            for (int i = 0; i < 4; i++) {
                int goX = p.x + toX[i];
                int goY = p.y + toY[i];

                if (goX < 0 || goX >= n || goY < 0 || goY >= m) continue;
                if (arr[goX][goY] == 1) {
                    // 벽을 만났다!
                    if (p.broken == true) continue; // 뚫을 수 없으면 패쓰!
                    if (visited[goX][goY][WALL]) continue; // 이미 뚫어서 방문했다면 패쓰!

                    q.offer(new Pair(goX, goY, p.count + 1, true));
                    visited[goX][goY][WALL] = true;
                }

                if (arr[goX][goY] == 0) {
                    // 벽이 아닌 경우
                    if (p.broken && !visited[goX][goY][WALL]) {
                        q.offer(new Pair(goX, goY, p.count + 1, p.broken));
                        visited[goX][goY][WALL] = true;
                    }
                    if (!p.broken && !visited[goX][goY][STREET]) {
                        q.offer(new Pair(goX, goY, p.count + 1, p.broken));
                        visited[goX][goY][STREET] = true;
                    }

                }
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(moving_demo(N, M, arr));
    }
}