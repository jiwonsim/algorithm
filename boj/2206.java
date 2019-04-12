import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, arr[][];
    static int temp1[][], temp2[][];
    static ArrayList<Pair> lists;
    static int result = -1;
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};

    public static void solve(int temp[][], int startX, int startY) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(startX, startY));
        temp[startX][startY] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int goX = p.x + toX[i];
                int goY = p.y + toY[i];

                if (goX < 0 || goX >= N || goY < 0 || goY >= M) continue;

                if (arr[goX][goY] != 0)  continue;
                if (temp[goX][goY] != 0) continue;

                temp[goX][goY] = temp[p.x][p.y] + 1;
                q.offer(new Pair(goX, goY));
            }
        }
    }

    public static void breakWall() {
        for(Pair list : lists) {
            for(int p = 0; p< 4; p++) {
                int x1 = list.x + toX[p];
                int y1 = list.y + toY[p];
                if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) continue;
                if(temp1[x1][y1] == 0) continue;
                int pivot = temp1[x1][y1];


                int min = -1;
                for(int dir = 0; dir < 4; dir++) {

                    int x2 = list.x + toX[dir];
                    int y2 = list.y + toY[dir];
                    if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                    if(temp2[x2][y2] == 0) continue;
                    min = min == -1 || min > temp2[x2][y2] ? temp2[x2][y2] : min;
                }
                if(min == -1) continue;
                result = result == -1 || result > pivot + min + 1 ? pivot + min + 1 : result;
            }
        }
    }

    public static void printArr(int[][] arr) {
        for(int i = 0; i< N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList<>();

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 1) lists.add(new Pair(i, j));
            }
        }

        temp1 = new int[N][M];
        temp2 = new int[N][M];

        solve(temp1, 0, 0); // (0,0)부터 시작
//        printArr(temp1);

        solve(temp2, N - 1, M - 1); // (N-1, M-1)부터 시작
//        printArr(temp2);


        if (temp1[N - 1][M - 1] != 0)
            result = temp1[N - 1][M - 1];
        else
            breakWall();

        System.out.println(result);
    }
}