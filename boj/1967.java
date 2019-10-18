import java.util.*;

class Edge {
    int vertex, weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<Edge>[] tree;
    static int[] dist;
    static int res, root;

    static void search(int vertex, int d) {
        dist[vertex] = d;

        if (res < dist[vertex]) {
            res = dist[vertex];
            root = vertex;
        }

        for (Edge e : tree[vertex]) {
            if (dist[e.vertex] == 0) search(e.vertex, d + e.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = (ArrayList<Edge>[]) new ArrayList[10001];

        // tree 초기화
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        dist = new int[10001];
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int weight = sc.nextInt();
            tree[parent].add(new Edge(child, weight));
            tree[child].add(new Edge(parent, weight));
        }

        search(1, 0);
        res = 0;
        dist = new int[10001];

        search(root, 0);
        System.out.printf("%d", res);
    }
}