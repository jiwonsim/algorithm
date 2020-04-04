import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int node;
    long cost;

    Edge(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge target) {
        return (int)(this.cost - target.cost);
    }
}

public class Main {

    static int N, E, MAX = 1000000000;
    static long[][] map, dis;
    static int p1, p2;

    static void search(int x) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (i == x) continue;
            pq.add(new Edge(i, map[x][i]));
            dis[x][i] = map[x][i];
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dis[x][cur.node]) continue;

            for (int i = 1; i <= N; i++) {
                if (map[cur.node][i] == 0) continue;
                if (dis[x][cur.node] + map[cur.node][i] < dis[x][i]) {
                    dis[x][i] = dis[x][cur.node] + map[cur.node][i];
                    pq.add(new Edge(i, dis[x][i]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화하기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        map = new long[N + 1][N + 1];
        dis = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = MAX;
            }
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            map[a][b] = c;
            map[b][a] = c;
        }

        input = br.readLine().split(" ");
        p1 = Integer.parseInt(input[0]);
        p2 = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) {
            search(i);
        }

        long result;
        result = Math.min(dis[1][p1] + dis[p1][p2] + dis[p2][N],
                dis[1][p2] + dis[p2][p1] + dis[p1][N]);
        if (result >= MAX) result = -1;
        System.out.println(result);

    }
}