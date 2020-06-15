import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static ArrayList<Integer>[] relation;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        relation = new ArrayList[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");

            int e1 = Integer.parseInt(input[0]);
            int e2 = Integer.parseInt(input[1]);

            relation[e1].add(e2);
            relation[e2].add(e1);
        }

        visited = new boolean[N + 1];
        find(1);

        StringBuffer result = new StringBuffer();
        for (int i = 2; i <= N; i++) {
            result.append(parents[i] + "\n");
        }

        bw.write(result.toString());
        bw.flush();
    }

    static void find(int node) {

        for (int ele : relation[node]) {
            if (visited[ele]) continue;

            visited[ele] = true;
            parents[ele] = node;
            find(ele);
        }
    }
}