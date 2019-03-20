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

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(N, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.current == K) {
                System.out.println(p.count);
                break;
            }

            if (visited[p.current]) continue;
            else visited[p.current] = true;

            //내가 틀린 이유 1. visited[]가 아닌 depth[]를 써서.
            //class Pair로 해주는 게 더 가독성이 좋고 안 헷갈리니까 담부터는 Pair 이용!
            //내가 틀린 이유 2. if의 순서. *2를 먼저 넣고 -1인 경우도 +1보다 우선으로 넣어줘야 한다.
            //왜냐하면... (모름)
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
    }
}