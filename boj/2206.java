import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 FAQ https://www.acmicpc.net/board/view/27386

class Pair {
    int x;
    int y;
    int broken;

    Pair(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}

public class Main {
    static int N, M, arr[][], count;
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};
    static boolean visited[][][];
    static int WALL = 1, EMPTY = 0;

    public static boolean checkRange(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) return true;
        else return false;
    }

    public static int bfs() {
        boolean end = false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, EMPTY));
        visited[0][0][WALL] = true;
        visited[0][0][EMPTY] = true;

        while (!q.isEmpty()) {
            count++;
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Pair p = q.poll();


                if (p.x == N - 1 && p.y == M - 1) {
                    end = true;
                    break;
                }


                for (int i = 0; i < 4; i++) {
                    int goX = p.x + toX[i];
                    int goY = p.y + toY[i];

                    if (!checkRange(goX, goY)) continue;

                    //벽인 경우
                    if (arr[goX][goY] == 1) {
                        if (!visited[goX][goY][WALL] && p.broken == EMPTY) {
                            q.offer(new Pair(goX, goY, WALL));
                            visited[goX][goY][WALL] = true;
                        }
                    }
                    //벽이 아닌 경우
                    else {
                        if (!visited[goX][goY][p.broken]) {
                            q.offer(new Pair(goX, goY, p.broken));
                            visited[goX][goY][p.broken] = true;
                        }
                    }
                }
            }
        }
        return end ? count : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}