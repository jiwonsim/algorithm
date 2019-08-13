import java.util.*;

class Pair {
    int len, buf, cnt;
    Pair(int len, int buf, int cnt) {
        this.len = len;
        this.buf = buf;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        boolean[][] visited = new boolean[3000][3000];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 0, 0));
        visited[0][0] = true;

        int res = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.len == S) {
                res = p.cnt;
                break;
            }

            //복사
            q.offer(new Pair(p.len, p.len, p.cnt + 1));

            //붙여넣기
            if (p.buf != 0) {
                if (!visited[p.len + p.buf][p.buf] && p.len + p.buf < 1001) {
                    visited[p.len + p.buf][p.buf] = true;
                    q.offer(new Pair(p.len + p.buf, p.buf, p.cnt + 1));
                }
            }

            //삭제
            if (p.len > 0) {
                if (!visited[p.len - 1][p.buf] && p.len - 1 < 1001) {
                    visited[p.len - 1][p.buf] = true;
                    q.offer(new Pair(p.len - 1, p.buf, p.cnt + 1));
                }
            }
        }

        System.out.printf("%d", res);
    }
}