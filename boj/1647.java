import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int[] nodes = new int[2]; // node
        int distance;

        Edge(int x, int y, int dis) {
            this.nodes[0] = x;
            this.nodes[1] = y;
            this.distance = dis;
        }

        @Override
        public int compareTo(Edge target) {
            return this.distance - target.distance;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        parent[y] = x;
    }

    static boolean isSameParent(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");

            pq.add(new Edge(Integer.parseInt(edge[0]),
                    Integer.parseInt(edge[1]),
                    Integer.parseInt(edge[2])));
        }

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int sum = 0, count = 0;
        while (count < N - 2){
            Edge edge = pq.poll();

            boolean isCyclic = isSameParent(parent, edge.nodes[0] - 1, edge.nodes[1] - 1);

            if (!isCyclic) { // there is no cycle;
                sum += edge.distance;
                union(parent, edge.nodes[0] - 1, edge.nodes[1] - 1);
                count++;
            }
        }

        System.out.println(sum);
    }
}