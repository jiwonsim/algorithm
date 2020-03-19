import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int distance;

        Edge(int node1, int node2, int distance) {
            this.node[0] = node1;
            this.node[1] = node2;
            this.distance = distance;
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

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int sum = 0;
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            if (m == 0 && n == 0) break;

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            while (n-- > 0) {
                input = br.readLine().split(" ");

                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);

                Edge data = new Edge(x, y, z);
                pq.add(data);
                sum += z;
            }

            int[] parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                if (find(parent, edge.node[0]) != find(parent, edge.node[1])) {
                    // no cycle
                    sum -= edge.distance;
                    union(parent, edge.node[0], edge.node[1]);
                }
            }

            bw.write(sum + "\n");
            bw.flush();
        }
    }
}