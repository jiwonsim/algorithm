import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static boolean[] visited;
    static int[] comb;
    static int[] numbers;

    public static void main(String[] args) throws IOException {

        // init & input
        String[] nm = br.readLine().split(" ");

        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        String[] input = br.readLine().split(" ");
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(input[i - 1]);
        }

        visited = new boolean[N + 1];
        comb = new int[M + 1];

        Arrays.sort(numbers);

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            comb[1] = numbers[i];
            search(i, 2);
            visited[i] = false;
        }
    }

    static void search(int num, int depth) throws IOException {
        if (depth > M) {
            for (int i = 1; i <= M; i++) {
                bw.write(comb[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            comb[depth] = numbers[i];
            search(i, depth + 1);
            visited[i] = false;
        }
    }

}