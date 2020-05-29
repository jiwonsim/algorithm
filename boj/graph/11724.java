import java.util.*;

public class Main {

    static int N, M, cntOfLink = 0;
    static ArrayList<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            map[u].add(v);
            map[v].add(u);
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            search(i);

            cntOfLink++;
        }

        System.out.println(cntOfLink);

    }

    static void search(int index) {

        for (int ele : map[index]) {
            if (visited[ele]) continue;

            visited[ele] = true;
            search(ele);
        }
    }
}