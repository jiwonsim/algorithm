
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y, d;
    int count;
    Pair(int x, int y, int d, int count) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.count = count;
    }
}

public class Main {
    static int M, N, H, empty;
    static int arr[][][];
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};
    static int toD[] = {1, -1};
    static Queue<Pair> q = new LinkedList<>();
    static boolean visited[][][];

    public static boolean checkRange(int x, int y, int d) {
        if (x >= 0 && x < N && y >= 0 && y < M && d >= 0 && d < H) return true;
        else return false;
    }

    public static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] == -1) continue;
                    if (arr[j][k][i] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void print() {

        System.out.println("****************");
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(arr[j][k][i] + " ");
                }
                System.out.println();
            }
        }


    }

    public static int solve() {
        if (empty == 0) return 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

//            System.out.println("********" + p.count +"********");
//            print();


            for (int i = 0; i < 4; i++) {
                int goX = p.x + toX[i];
                int goY = p.y + toY[i];

                if (!checkRange(goX, goY, p.d)) continue;
                if (arr[goX][goY][p.d] == -1 || arr[goX][goY][p.d] == 1 || visited[goX][goY][p.d]) continue;
                q.offer(new Pair(goX, goY, p.d, p.count + 1));
                visited[goX][goY][p.d] = true;
                arr[goX][goY][p.d] = 1;
                empty--;
            }

            for (int j = 0; j < toD.length; j++) {
                int goD = p.d + toD[j];

                if (!checkRange(p.x, p.y, goD)) continue;
                if (arr[p.x][p.y][goD] == -1 || arr[p.x][p.y][goD] == 1 || visited[p.x][p.y][goD]) continue;
                q.offer(new Pair(p.x, p.y, goD, p.count + 1));
                visited[p.x][p.y][goD] = true;
                arr[p.x][p.y][goD] = 1;
                empty--;
            }
//            print();
//            System.out.println("빈 공간 : " + empty);
//            System.out.println("카운트 : " + (p.count + 1));

            if (empty == 0)
            {
                return p.count + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        arr = new int[N][M][H];
        visited = new boolean[N][M][H];
        empty = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String input_arr[] = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    arr[j][k][i] = Integer.parseInt(input_arr[k]);
                    if (arr[j][k][i] == 1) {
                        q.offer(new Pair(j, k, i, 0));
                    }
                    if (arr[j][k][i] == 0) empty++;
                }
            }
        }


//        System.out.println("빈 공간 : " + empty);
        System.out.println(solve());
//        print();

    }
}