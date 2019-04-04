import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static boolean visited[];
    static int N, MIN = Integer.MAX_VALUE, start;
    public static void check(int x, int y, int depth, int sum) {
        if (depth == N && start == y) {
            MIN = Integer.min(sum, MIN);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] || arr[y][i] == 0)
                continue;
            visited[i] = true;
            check(y, i, depth + 1, sum + arr[y][i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            start = i;
            check(i, i, 0, 0);
        }

        System.out.println(MIN);
    }
}