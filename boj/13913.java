import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int current = 0;
    int count = 0;
    public Pair(int current, int count) {
        this.current = current;
        this.count = count;
    }
}

public class Main {
    static int N, K;
    static boolean visited[];
    static int trace[];
    static int depth = Integer.MAX_VALUE;

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(N, 0));
        visited[N] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.current == K) {
                depth = Math.min(depth, p.count);
                break;
            }

            if (p.current * 2 <= 100000 && trace[p.current * 2] == -1) {
                q.offer(new Pair(p.current * 2, p.count + 1));
                trace[p.current * 2] = p.current;
            }
            if (p.current - 1 >= 0 && trace[p.current - 1] == -1) {
                q.offer(new Pair(p.current - 1, p.count + 1));
                trace[p.current - 1] = p.current;
            }
            if (p.current + 1 <= 100000 && trace[p.current + 1] == -1) {
                q.offer(new Pair(p.current + 1, p.count + 1));
                trace[p.current + 1] = p.current;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        trace = new int[100001];
        Arrays.fill(trace, -1);
        bfs();
        System.out.println(depth);
        int idx = K, list[] = new int[depth], i = 0;
        while (idx != N) {
            list[i++] = trace[idx];
            idx = trace[idx];
        }

        for (int j = depth - 1; j >= 0; j--) {
            System.out.print(list[j] + " ");
        }
        System.out.println(K);

    }
}