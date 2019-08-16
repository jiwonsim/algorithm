import java.util.*;

// 19.08.16 20:14 ~ 21:53


class Pair {
    int rx, ry;
    int bx, by;
    int cnt;

    Pair(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }

    int x, y, sum;

    Pair (int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}

public class Main {

    static int N, M, rx, ry, bx, by;
    static int goalX, goalY;
    static char[][] arr;
    static int[] toX = {1, -1, 0, 0}, toY = {0, 0, 1, -1};

    public static Pair move(int x, int y, int c, int d) {
        while (arr[x + toX[d]][y + toY[d]] != '#' && arr[x][y] != 'O') {
            x += toX[d];
            y += toY[d];
            c++;
        }
        Pair p = new Pair(x, y, c);
        return p;
    }


    public static int solve() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        q.add(new Pair(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;



        while (!q.isEmpty()) {
            Pair p = q.poll();


            for (int i = 0; i < 4; i++) {
                Pair nextRp = move(p.rx, p.ry, p.cnt, i);
                Pair nextBp = move(p.bx, p.by, p.cnt, i);



                if (arr[nextBp.x][nextBp.y] == 'O') {
                    continue;
                } // 순서가 중요! 파란공을 먼저 검사해야 거를 수 있음.


                if (arr[nextRp.x][nextRp.y] == 'O') {
                    return p.cnt + 1;
                }


                // 둘이 겹칠 때..
                if (nextRp.x == nextBp.x && nextRp.y == nextBp.y) {
                    if (nextRp.sum > nextBp.sum) {
                        nextRp.x -= toX[i];
                        nextRp.y -= toY[i];
                    }
                    else {
                        nextBp.x -= toX[i];
                        nextBp.y -= toY[i];
                    }
                }

                // 방문체크..
                if (visited[nextRp.x][nextRp.y][nextBp.x][nextBp.y]) continue;
                visited[nextRp.x][nextRp.y][nextBp.x][nextBp.y] = true;
                q.add(new Pair(nextRp.x, nextRp.y, nextBp.x, nextBp.y, p.cnt + 1));

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String in = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.charAt(j);
                if (arr[i][j] == 'O') {
                    goalX = i; goalY = j;
                }
                if (arr[i][j] == 'R') {
                    rx = i; ry = j;
                }
                if (arr[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        System.out.printf("%d", solve());
    }
}