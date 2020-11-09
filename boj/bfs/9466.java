import java.util.*;
import java.io.*;

public class Main {

    static int n, answer;
    static int[] array;
    static boolean[] visited, matched;

    static void go(int node) {
        if (visited[node]) {
            // 이미 이전에 방문했으면 싸이클이다!
            if (!matched[node]) {
                // 싸이클 카운팅을 했는지 확인!
                int next = array[node];
                answer+=1;
                while (next != node) {
                    answer+=1;
                    next = array[next];
                }
            }
        }
        else {
            // 방문할 때까지 탐색을 계속한다.
            visited[node] = true;
            go(array[node]);
        }
        matched[node] = true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(reader.readLine());
            array = new int[n+1];
            visited = new boolean[n+1];
            matched = new boolean[n+1];
            answer = 0;

            String[] input = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(input[i-1]);
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                go(i);
            }

            writer.write(n-answer + "\n");
            writer.flush();
        }
        writer.close();

    }
}
