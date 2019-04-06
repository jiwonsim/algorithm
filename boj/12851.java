import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int count, current;

    Pair(int count, int current) {
        this.count = count;
        this.current = current;
    }
}

public class Main {
    static int N, K, arr[] = new int[100001];
    static int count, MIN = Integer.MAX_VALUE;
    static boolean visited[] = new boolean[100001];

    public static void solve() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, N));
        visited[N] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.current] = true;

            if (p.current == K) {
                MIN = Math.min(MIN, p.count);
                if (MIN != p.count) break;
                count++;
            }

            int arr[] = new int[3];
            arr[0] = p.current - 1;
            arr[1] = p.current + 1;
            arr[2] = p.current * 2;
            for (int i = 0; i < arr.length; i++) {
                int next = arr[i];
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    q.offer(new Pair(p.count + 1, next));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        solve();
        System.out.println(MIN);
        System.out.println(count);
    }
}