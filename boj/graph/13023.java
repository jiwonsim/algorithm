import java.util.*;

public class Main {
    static int n, m, result;
    static boolean[] related;
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        related = new boolean[n];
        nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            nodes[from].add(to);
            nodes[to].add(from);
        }

        result = 0;
        for (int i = 0; i < nodes.length; i++) {
            search(i, 1);
            if (result == 1) break;
        }

        System.out.println(result);
    }

    static void search(int vertex, int depth) {
        if (depth == 5 || result == 1) {
            result = 1;
            return;
        }

        related[vertex] = true;
        for (int i = 0; i < nodes[vertex].size(); i++) {
            if (related[nodes[vertex].get(i)]) continue;
            related[nodes[vertex].get(i)] = true;
            search(nodes[vertex].get(i), depth + 1);
            related[nodes[vertex].get(i)] = false;
        }
        related[vertex] = false;
    }
}