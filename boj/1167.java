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

    static void search(int v, int d) {
        if (MAX < d) {
            MAX = d;
            index = v;
        }

        for (int j = 0; j < tree[v].size(); j++) {
            Pair next = tree[v].get(j);
            if (visited[next.v]) continue;
            visited[next.v] = true;
            search(next.v, d + next.d);
            visited[next.v] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];
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

        for (int i = 1; i <= V; i++) {
            visited[i] = true;
            search(i, 0);
            visited[i] = false;
        }

        System.out.printf("%d", MAX);
    }
}