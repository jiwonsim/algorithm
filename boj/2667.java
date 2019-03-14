import java.lang.reflect.Array;
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
    static int N;
    static int arr[][];
    static String square[];
    static int visited[][];
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};

    static int count;
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean checkRange(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) return true;
        else return false;
    }

    public static void bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        int area = 0;

        q.offer(p);
        visited[p.x][p.y] = 1;
        while (!q.isEmpty()) {
            Point next = q.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                int goX = next.x + toX[i];
                int goY = next.y + toY[i];
                if (checkRange(goX, goY) && arr[goX][goY] == 1 && visited[goX][goY] == 0) {
                    q.offer(new Point(goX, goY));
                    visited[goX][goY] = 1;
                }
            }
        }

        list.add(area);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        visited = new int[N][N];
        square = new String[N];

        for (int i = 0; i < N; i++) {
            square[i] = sc.next();

            for (int j = 0; j < square[i].length(); j++) {
                arr[i][j] = square[i].charAt(j) - 48;
            }
        }

        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    bfs(new Point(i, j));
                    index++;
                    count++;
                }
            }
        }
        list.sort(null);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}