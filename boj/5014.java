import java.util.*;

// 0830 17:05 ~ 17:26

class Pair {
    int s, cnt;
    Pair(int s, int cnt) {
        this.s = s;
        this.cnt = cnt;
    }
}

public class Main {
    static int F, S, G, U, D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[10000001];

        q.add(new Pair(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.s == G) {
                System.out.printf("%d", cur.cnt);
                return;
            }


            if (cur.s + U <= F && !visited[cur.s + U]) {
                q.add(new Pair(cur.s + U, cur.cnt +  1));
                visited[cur.s + U] = true;
            }
            if (cur.s - D >= 0 && !visited[cur.s - D]) {
                q.add(new Pair(cur.s - D, cur.cnt + 1));
                visited[cur.s - D] = true;
            }
        }

        System.out.printf("use the stairs");

    }
}