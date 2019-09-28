import java.util.*;

public class Main {
    static int[] times, income;
    static int MAX = Integer.MIN_VALUE;
    static boolean[] visited;

    static int search(int day, int N, int res) {
        if (day > N) return res;

        for (int i = day + 1; i <= N; i++) {
            if (visited[i]) continue;
            if (i < day + times[day]) continue;
            if (i + times[i] > N + 1) continue;

            visited[i] = true;
            MAX = Math.max(search(i, N, res + income[i]), MAX);
            visited[i] = false;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        times = new int[N + 1];
        income = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            times[i] = sc.nextInt();
            income[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (i + times[i] > N + 1) continue;
            visited = new boolean[N + 1];
            int res = search(i, N, income[i]);
            MAX = Math.max(MAX, res);
        }

        System.out.printf("%d", MAX == Integer.MIN_VALUE ? 0 : MAX);
    }
}