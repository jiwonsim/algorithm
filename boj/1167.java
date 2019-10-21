import java.util.*;

class Pair {
    int v, d;

    Pair(int v, int d) {
        this.v = v;
        this.d = d;
    }
}

public class Main {
    static ArrayList<Pair>[] tree;
    static int V, res, MAX = 0, index;
    static boolean[] visited;
    static int dist[];

    // bfs
    static void search(int start) {

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < tree[p.v].size(); i++) {
                int nextV = tree[p.v].get(i).v;
                int nextD = tree[p.v].get(i).d;

                if (visited[nextV]) continue;
                visited[nextV] = true;
                q.add(new Pair(nextV, p.d + nextD));
                dist[nextV] = p.d + nextD;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        tree = new ArrayList[V + 1];
        for (int i = 0; i < tree.length; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            int v = sc.nextInt();
            while (true) {
                int in = sc.nextInt();
                if (in == -1) break;
                int vd = sc.nextInt();
                tree[v].add(new Pair(in, vd));
            }
        }

        search(1);

        int index = -1;
        for (int i = 1; i < dist.length; i++) {
            if (MAX < dist[i]) {
                index = i;
                MAX = dist[i];
            }
        }

        search(index);

        Arrays.sort(dist);
        System.out.printf("%d", dist[dist.length - 1]);
    }
}