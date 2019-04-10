import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y, broken;
    Pair(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}

public class Main {
    static int N, M, arr[][];
    static boolean isBroken = false, visited[][][];
    static int to_x[] = {0, 0, 1, -1};
    static int to_y[] = {1, -1, 0, 0};

    public static boolean check_ragne(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) return true;
        else return false;
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        int count = 0;
        boolean move = true;
        while (!q.isEmpty() && !isBroken) {
            count++;
            System.out.println("count++");

            for (int j = 0; j < q.size(); j++) {
                Pair p = q.poll();
//            System.out.println(p.broken);
                System.out.println("current : (" + p.x + ", " + p.y + ")");

                if (p.x == N - 1 && p.y == M - 1) {
                    isBroken = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int go_x = p.x + to_x[i];
                    int go_y = p.y + to_y[i];

                    if (!check_ragne(go_x, go_y)) continue;

                    //벽인 경우
                    if (arr[go_x][go_y] == 1) {
                        //p.broken == 0이어야 함.
                        if (p.broken == 0 && !visited[go_x][go_y][1]) {
                            System.out.println("(" + p.x + ", " + p.y + ") -> (" + go_x + ", " + go_y + ")");
                            q.offer(new Pair(go_x, go_y, 1));
                            visited[go_x][go_y][1] = true;
                        }
                    }
                    //벽이 아닌 경우
                    else {
                        if (!visited[go_x][go_y][p.broken]) {
                            System.out.println("(" + p.x + ", " + p.y + ") -> (" + go_x + ", " + go_y + ")");
                            q.offer(new Pair(go_x, go_y, p.broken));
                            visited[go_x][go_y][p.broken] = true;
                        }
                    }
                }
                System.out.println("out");
            }
            System.out.println("out2");
        }
        return isBroken ? count : -1;
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
