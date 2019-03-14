import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int u, v;
    static int arr[][];
    static int visited[];
    static int count;

    public static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(u);
        visited[u] = 1;

        while (!q.isEmpty()) {
            int k = q.poll();
            for (int i = 0; i < N; i++) {
                if (arr[k][i] == 1 && visited[i] == 0) {
                    q.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][N];
        visited = new int[N];

        for (int i = 0; i < M; i++) {
            u = sc.nextInt() - 1;
            v = sc.nextInt() - 1;

            arr[u][v] = 1;
            arr[v][u] = 1;
        }


        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}