import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int M;
    static int N;
    static int K;
    static boolean square[][];
    static int area = 0;

    public static boolean checkRange(int x, int y) {
        if (x>=0 && y>=0 && x<N && y<M) {
            return true;
        }
        else return false;
    }

    public static int bfs(int cur_x, int cur_y) {
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};

        int res = 0;
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(cur_x, cur_y));
        square[cur_x][cur_y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            res++;
            for (int i=0; i<4; i++) {
                int go_x = p.x + x[i];
                int go_y = p.y + y[i];

                if(checkRange(go_x, go_y) && square[go_x][go_y] == false) {
                    q.offer(new Point(go_x, go_y));
                    square[go_x][go_y] = true;
                }
            }
        }
        area++;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        square = new boolean[N][M];

        while (K-- != 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();


            for (int j=y1; j<y2; j++) {
                for (int i=x1; i<x2; i++) {
                    square[i][j] = true;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (square[i][j] == false) {
                    list.add(bfs(i, j));
                }
            }
        }

        list.sort(null);
        System.out.println(area);
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}