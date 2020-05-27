import java.util.*;

public class Main {

    static int V, E;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            V = sc.nextInt();
            E = sc.nextInt();

            map = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                map[i] = new ArrayList<>();
            }

            while (E-- > 0) {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;

                map[from].add(to);
                map[from].add(to);
            }

            if (search()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean search() {
        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[V];

        boolean result = true;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                que.add(i);
                visited[i] = 1;
            }

            while (!que.isEmpty() && result) {
                int cur = que.poll();

                for (int num : map[cur]) {
                    if (visited[num] == 0) {
                        que.add(num);
                        visited[num] = visited[cur] * -1;
                    }
                    else if (visited[num] == visited[cur]) {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }
}