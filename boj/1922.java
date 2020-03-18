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
        x = parent[x];
        y = parent[y];

        if (x < y) parent[y] = x;
        else parent[x] = y;
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

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            list.add(new Edge(Integer.parseInt(input[0]),
                            Integer.parseInt(input[1]),
                            Integer.parseInt(input[2])));
        }

        Collections.sort(list);

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean isCyclic = isSameParent(parent, list.get(i).nodes[0] - 1, list.get(i).nodes[1] - 1);
            if (!isCyclic) { // there is no cycle;
                sum += list.get(i).distance;
                union(parent, list.get(i).nodes[0] - 1, list.get(i).nodes[1] - 1);
            }
        }

        System.out.println(sum);
    }
}