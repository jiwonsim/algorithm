import java.util.*;

class Pos implements Comparable<Pos> {
    int x, y, cntDay;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Pos(int x, int y, int cntDay) {
        this.x = x;
        this.y = y;
        this.cntDay = cntDay;
    }

    @Override
    public int compareTo(Pos p) {
        return this.cntDay - p.cntDay;
    }
}

public class Main {
    static int R, C, minIce = Integer.MAX_VALUE;
    static char[][] lake;
    static int[][] meltingDay;
    static int[] toX = {0, 0, 1, -1}, toY = {1, -1, 0, 0};

    static boolean isInRange(int x, int y) {
        if (x < 0 || y < 0 || x >= R || y >= C) return false;
        return true;
    }

    static void calcMeltingDay() {
        List<Pos> waterList = new ArrayList<>();
        boolean[][] checkWater = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] == '.' || lake[i][j] == 'L') {
                    waterList.add(new Pos(i, j));
                    checkWater[i][j] = true;
                }
            }
        }

        Queue<Pos> iceQue = new LinkedList<>();

        for (Pos water : waterList) {
            for (int i = 0; i < 4; i++) {
                int nextX = toX[i] + water.x;
                int nextY = toY[i] + water.y;

                if (!isInRange(nextX, nextY)) continue;
                if (checkWater[nextX][nextY]) continue;

                checkWater[nextX][nextY] = true;
                meltingDay[nextX][nextY] = 1;
                iceQue.add(new Pos(nextX, nextY));
            }
        }

        while (!iceQue.isEmpty()) {
            Pos curIce = iceQue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = toX[i] + curIce.x;
                int nextY = toY[i] + curIce.y;

                if (!isInRange(nextX, nextY)) continue;
                if (checkWater[nextX][nextY]) continue;
                meltingDay[nextX][nextY] = meltingDay[curIce.x][curIce.y] + 1;
                checkWater[nextX][nextY] = true;
                iceQue.add(new Pos(nextX, nextY));
            }
        }
    }

    static int searchSwan(int sx, int sy, int ex, int ey) {
        PriorityQueue<Pos> q = new PriorityQueue<>();
        boolean visited[][] = new boolean[R][C];

        q.add(new Pos(sx, sy, 0));
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == ex && cur.y == ey) {
                return cur.cntDay;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = toX[i] + cur.x;
                int nextY = toY[i] + cur.y;

                if (!isInRange(nextX, nextY)) continue;
                if (visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                q.add(new Pos(nextX, nextY, Math.max(meltingDay[nextX][nextY], cur.cntDay)));
            }
        }

        System.out.printf("%d\n", minIce);
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        // 시작 백조, 끝 백조
        int sx = 0, sy = 0, ex = 0, ey = 0, sidx = 0;

        lake = new char[R][C];
        meltingDay = new int[R][C];
        for (int i = 0; i < R; i++) {
            String in = sc.next();
            for (int j = 0; j < C; j++) {
                lake[i][j] = in.charAt(j);

                // 백조 위치 저장
                if (lake[i][j] == 'L') {
                    if (sidx == 0) {
                        sx = i;
                        sy = j;
                        sidx++;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        calcMeltingDay();
//        System.out.printf("%d %d %d %d\n", sx, sy, ex, ey);
        int answer = searchSwan(sx, sy, ex, ey);
        System.out.printf("%d", answer);



    }
}