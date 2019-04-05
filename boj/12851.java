import sun.nio.cs.ext.MacHebrew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int cur, cnt;
    Pair(int cur, int cnt) {
        this.cur = cur;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, K, count = 0, MIN = Integer.MAX_VALUE;
    static int to[] = new int[]{-1, 0, 1};
    static boolean visited[] = new boolean[100001];

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(N, 0));
        visited[N] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            visited[p.cur] = true;
            if (p.cur == K) {
                MIN = Math.min(MIN, p.cnt);
                if (MIN != p.cnt) break;
                count++;
            }

            for (int i = 0; i < to.length; i++) {
                int next;
                if (to[i] == 0)
                    next = p.cur * 2;
                else
                    next = p.cur + to[i];

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    q.offer(new Pair(next, p.cnt + 1));
                }
            }
        }

        return MIN;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
        System.out.println(count);

    }
}