import java.util.*;
import java.io.*;

public class Main {

    static int EARLY = 1, NONE = 0;
    static int N;
    static ArrayList<Integer>[] related;
    static int[][] dp;
    static boolean[] visited;

    static void dfs(int index) {

        visited[index] = true;
        dp[index][NONE] = 0;
        dp[index][EARLY] = 1;

        for (int child : related[index]) {
            if (visited[child]) continue;

            dfs(child);
            dp[index][NONE] += dp[child][EARLY];
            dp[index][EARLY] += Math.min(dp[child][EARLY], dp[child][NONE]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        related = new ArrayList[N+1];
        dp = new int[N+1][2];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) related[i] = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            String[] input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            related[from].add(to);
            related[to].add(from);
        }

        dfs(1);

        writer.write(Math.min(dp[1][EARLY], dp[1][NONE]) + "\n");
        writer.flush();
        writer.close();
    }
}

