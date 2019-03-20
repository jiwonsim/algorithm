import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int current = 0, count = 0;
    Pair(int current, int count) {
        this.current = current;
        this.count = count;
    }
}

public class Main {
    static int N, K;
    static boolean visited[];
    static int min = Integer.MAX_VALUE;

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(N, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.current == K) {
                min = Math.min(min, p.count);
                break;
            }
            if (visited[p.current]) continue;
            else visited[p.current] = true;

            // 틀렸던 이유 : depth[]로 해서.. visited[]로 *2를 먼저 체크해줘야함.
            if (p.current * 2 <= 100000 && !visited[p.current * 2]) {
                q.offer(new Pair(p.current * 2, p.count));
            }
            if (p.current - 1 >= 0 && !visited[p.current - 1]) {
                q.offer(new Pair(p.current - 1, p.count + 1));
            }
            if (p.current + 1 <= 100000 && !visited[p.current + 1]) {
                q.offer(new Pair(p.current + 1, p.count + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        bfs();
        System.out.println(min);
    }
}