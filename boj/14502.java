import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int N, M;
    static int space[][];
    static int temp[][];
    static int virusTemp[][];
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};
    static int result;

    public static boolean checkRange(int x, int y) {
        if (x>=0 && y>=0 && x<N && y<M) {
            return true;
        }
        else return false;
    }

    public static void makeWallDFS(int wallCnt) {
        if (wallCnt == 3) {
            spreadVirusBFS();
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 0) {
                        temp[i][j] = 1;
                        makeWallDFS(wallCnt + 1);
                        temp[i][j] = 0;
                    }
                }
            }
        }

        safeArea();
    }

    public static int safeArea() {
        int safeAreaCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusTemp[i][j] == 0) {
                    safeAreaCnt++;
                }
            }
        }

        return result = Math.max(result, safeAreaCnt);
    }

    public static void spreadVirusBFS() {
        Queue<Point> virus = new LinkedList<Point>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                virusTemp[i][j] = temp[i][j];
                if (virusTemp[i][j] == 2) {
                    virus.offer(new Point(i, j));
                }
            }
        }

        while (!virus.isEmpty()) {
            Point p = virus.poll();

            for (int i=0; i<4; i++) {
                int goX = p.x + toX[i];
                int goY = p.y + toY[i];

                if (checkRange(goX, goY) && virusTemp[goX][goY] == 0) {
//                    System.out.println("["+goX+", "+goY+"] ");
                    virus.offer(new Point(goX, goY));
                    virusTemp[goX][goY] = 2;
                }
            }
        }
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<M; j++) {
//                System.out.print(virusTemp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        space = new int[N][M];
        temp = new int[N][M];
        virusTemp = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                space[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                temp[i][j] = space[i][j];
            }
        }

        makeWallDFS(0);

        System.out.println(result);
    }
}
