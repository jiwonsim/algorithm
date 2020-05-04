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

        comb = new int[M];
        numbers = new int[N];
        visited = new boolean[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(numbers);
        search(0);
    }

    static void search(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(comb[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        int before = -1;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (before == numbers[i]) continue;

            before = numbers[i];
            visited[i] = true;
            comb[depth] = numbers[i];
            search(depth + 1);
            visited[i] = false;
        }
    }

}