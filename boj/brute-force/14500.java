import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. ㅗ 모양을 제외한 나머지 값들은 4개의 깊이까지만 검사하는 dfs로 합을 구한다.
2. ㅗ 모양은 dfs로 풀 수 없슴! -> brute-force를 이용해서 합을 구한다.
3. 최대값 출력
 */

public class Main {
    static int N, M;
    static int MAX = Integer.MIN_VALUE;
    static int arr[][];
    static boolean visited[][];
    static int toX[] = {1, -1, 0, 0};
    static int toY[] = {0, 0, 1, -1};

    public static boolean checkRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < N && y < M) return true;
        return false;
    }
    /*
    혹시 CalculateSpecialBlock 에서 sx와 sy 값을 만들 때 (i + y) % 4 인덱스를 구하신 방법을 여쭤봐도 될까요?
     */

    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            MAX = Math.max(sum, MAX);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int goX = toX[i] + x;
            int goY = toY[i] + y;

            if (checkRange(goX, goY) && visited[goX][goY] == false) {
                visited[goX][goY] = true;
                dfs(goX, goY, depth+1, sum + arr[goX][goY]);
                visited[goX][goY] = false;
            }
        }
    }

    public static void mountainBlock(int x, int y) {
        int sum = 0;
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            sum = arr[x][y];
            flag = true;
            for (int j = 0; j < 3; j++) {
                int goX = x + toX[(i + j) % 4];
                int goY = y + toY[(i + j) % 4];

                if (checkRange(goX, goY)) {
                    sum += arr[goX][goY];
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag)
                MAX = Math.max(MAX, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            visited[x][y] = true;
            dfs(x, y, 1, arr[x][y]);
            mountainBlock(x, y);
            visited[x][y] = false;
        }

        System.out.println(MAX);
    }
}