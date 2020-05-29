import java.util.*;

public class Main {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static StringBuffer dfsRes, bfsRes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            map[v1].add(v2);
            map[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }

        dfsRes = new StringBuffer();
        bfsRes = new StringBuffer();

        // DFS
        visited = new boolean[N + 1];

        dfsRes.append(V + " ");
        visited[V] = true;
        dfs(V);

        System.out.println(dfsRes.toString());

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(bfsRes.toString());


    }

    static void dfs(int index) {

        for (int ele : map[index]) {
            if (visited[ele]) continue;
            visited[ele] = true;
            dfsRes.append(ele + " ");
            dfs(ele);
        }
    }

    static void bfs(int index) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(index);
        visited[index] = true;
        bfsRes.append(index + " ");

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int ele : map[cur]) {
                if (visited[ele]) continue;

                visited[ele] = true;
                bfsRes.append(ele + " ");
                que.add(ele);
            }
        }
    }
}