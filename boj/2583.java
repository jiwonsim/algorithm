import java.util.*;

class POINT {
    int x, y;
    POINT(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int x[] = {0, 0, 1, -1};
    public static int y[] = {1, -1, 0, 0};
    public static int[][] square;


    public static int M;
    public static int N;
    public static int K;

    public static int area = 0;

    public static int bfs(int cur_i, int cur_j) {
        Queue<POINT> q = new LinkedList<POINT>();

        q.offer(new POINT(cur_i, cur_j));
        square[cur_i][cur_j] = 1;


        int res = 0;
        while (!q.isEmpty()) {
            POINT p = q.poll();
            res++;
            for (int i=0; i<4; i++) {
                int res_x = p.x + x[i];
                int res_y = p.y + y[i];

                if (res_x >= 0 && res_y >= 0 && res_x < M && res_y < N && square[res_x][res_y] == 0) {
                    q.offer(new POINT(res_x, res_y));
                    square[res_x][res_y] = 1;
                }
            }
        }
        area++;
        return res;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        square = new int[M][N];

        for (int i=0; i<K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j=y1; j<y2; j++) {
                for (int k=x1; k<x2; k++) {
                    square[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(square[i][j] == 0) {
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
