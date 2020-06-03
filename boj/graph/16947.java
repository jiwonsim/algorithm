import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int[] visited, dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            arr[e1].add(e2);
            arr[e2].add(e1);
        }

        explore(1, -1);
        bfs();

        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ", dist[i]);
        }
    }

    static int explore(int index, int stand) {
        if (visited[index] == 1) return index;

        visited[index] = 1;
        for (int ele : arr[index]) {
            if (ele == stand) continue;

            int result = explore(ele, index);
            if (result == -2) return -2;

            if (result >= 0) {
                visited[index] = 2;
                if (index == result)
                    return -2;
                else return result;
            }
        }

        return -1;
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 2) {
                dist[i] = 0;
                que.add(i);
            }
            else dist[i] = -1;
        }

        while (!que.isEmpty()) {
            int cur = que.remove();

            for (int ele : arr[cur]) {
                if (dist[ele] == -1) {
                    que.add(ele);
                    dist[ele] = dist[cur] + 1;
                }
            }
        }
    }
}