import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] rel;
    static int[] result;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        rel = new ArrayList[N + 1];
        result = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            rel[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            rel[e1].add(e2);
            rel[e2].add(e1);
        }

        for (int i = 1; i <= N; i++) {
            result[i] = Integer.parseInt(sc.next());
        }

        System.out.printf("%d", search() ? 1 : 0);
    }

    static boolean search() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        que.add(1);
        visited[1] = true;

        int index = 2;
        for (int i = 1; i <= N; i++) {
            int cur = que.poll();

            int cnt = 0; // 자식 노드의 개수
            for (int child : rel[cur]) {
                if (visited[child]) continue;
                cnt++;
                parent[child] = cur;
            }

            for (int j = index; j < index + cnt; j++) {
                // 연결 안되거나 범위를 벗어날 때는 return false;
                if (j > N || parent[result[j]] != cur) return false;
                que.add(result[j]);
                visited[result[j]] = true;
            }

            index += cnt;
        }

        return true;
    }

}