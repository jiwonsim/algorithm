import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int visited[] = new int[100002];

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            N = q.poll();

            if (N == K) {
                break;
            }
            if (N-1 >= 0 && visited[N - 1] == 0) {
                q.add(N - 1);
                visited[N - 1] = visited[N] + 1;
            }
            if (N <= 100000 && visited[N + 1] == 0) {
                q.add(N + 1);
                visited[N + 1] = visited[N] + 1;
            }
            if (N * 2 <= 100000 && visited[N * 2] == 0) {
                q.add(N * 2);
                visited[N * 2] = visited[N] + 1;
            }
        }
        System.out.println(visited[K]-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        bfs();
    }
}