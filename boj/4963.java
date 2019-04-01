import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int w, h;
    static int land = 0;
    static int toX[] = {0, 0, 1, -1, 1, -1, 1, -1};
    static int toY[] = {1, -1, 0, 0, 1, 1, -1, -1};
    static boolean visited[][];

    public static boolean checkRange(int x, int y) {
        if (x >= 0 && x < h && y >= 0 && y < w) return true;
        else return false;
    }

    public static void countingLand(int arr[][], int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < toX.length; i++) {
                int goX = p.x + toX[i];
                int goY = p.y + toY[i];

                if (checkRange(goX, goY) && arr[goX][goY] == 1 && !visited[goX][goY]) {
                    q.offer(new Pair(goX, goY));
                    visited[goX][goY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) return;

            int arr[][] = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            land = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        countingLand(arr, i, j);
                        land++;
                    }
                }
            }
            System.out.println(land);
        }
    }
}