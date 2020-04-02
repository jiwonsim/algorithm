import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int node, cost;

    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.cost == e.cost) return this.node - e.node;
        return this.cost - e.cost;
    }
}

public class Main {

    static int MAX = 100000000;
    static ArrayList<Edge>[] list;
    static int N, M;
    static int[][] costs;
    static int[] dis;

    static void search(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dis[cur.node] < cur.cost) continue;
            for (int i = 0; i < list[cur.node].size(); i++) {
                int nextNode = list[cur.node].get(i).node;
                int nextDis = list[cur.node].get(i).cost + cur.cost;

                if (nextDis < dis[nextNode]) {
                    dis[nextNode] = nextDis;
                    pq.add(new Edge(nextNode, nextDis));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        costs = new int[N + 1][N + 1];
        dis = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                costs[i][j] = MAX;
            }
        }

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dis[i] = MAX;
        }

        String[] input;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);

            costs[s][e] = v;
            list[s].add(new Edge(e, v));
        }

        input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        search(start);
        int end = Integer.parseInt(input[1]);
        int result = dis[end];
        System.out.printf("%d", result);

    }
}