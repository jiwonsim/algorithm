import java.util.*;

class Point {
    int x, y, depth;
    Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Main {
    static int N, M;
    static int arr[][];
    static int cloneArr[][];
    static int toX[] = {1, -1, 0, 0};
    static int toY[] = {0, 0, 1, -1};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void countSquereSize(Point p) {
        int visited[][] = new int[N][M];
        int result = 0;
        Queue<Point> q = new LinkedList<>();

        q.offer(p);
        visited[p.x][p.y] = 1;
//        System.out.println("["+p.x+", "+p.y+"] : " + "result = " + result + "+" + arr[p.x][p.y]);
//        result += arr[p.x][p.y];

        while (!q.isEmpty()) {
            Point now = q.poll();
            System.out.println("["+now.x+", "+now.y+"] : " + now.depth);
            if (now.depth == 4) {
//                System.out.println("["+p.x+", "+p.y+"] : " + result);
                System.out.println();
                System.out.println("result : " + result);
                list.add(result);
                now.depth = 0;
                result = 0;
            }

            for (int i = 0; i < 4; i++) {
                int goX = toX[i] + now.x;
                int goY = toY[i] + now.y;

                if (goX >= 0 && goX < N && goY >= 0 && goY < M) {
                    if (visited[goX][goY] < 4) {
                        result += arr[goX][goY];
//                        System.out.println("["+goX+", "+goY+"] : result = " + result + "+"  + arr[goX][goY] + " / depth : " + now.depth );
                        q.offer(new Point(goX, goY, now.depth+1));
                        visited[goX][goY] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                countSquereSize(new Point(i, j, 1));
                System.out.println("!!!");
            }
        }

        System.out.println(Collections.max(list));
    }
}