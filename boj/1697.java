import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int depth[];

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(N);
        depth[N] = 1;
        while (!q.isEmpty()) {
            N = q.poll();

            if (N == K) {
                break;
            }
            if (N + 1 <= 100000 && depth[N + 1] == 0) {
                q.offer(N+1);
                depth[N+1] = depth[N] + 1;
            }
            if (N * 2 <= 100000 && depth[N * 2] == 0) {
                q.offer(N*2);
                depth[N*2] = depth[N] + 1;
            }
            if (N - 1 >= 0 && depth[N-1] == 0) {
                q.offer(N-1);
                depth[N-1] = depth[N] + 1;
            }
        }
        System.out.println(depth[K]-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        depth = new int[100001];

        bfs();
    }
}