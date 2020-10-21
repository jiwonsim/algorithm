import java.util.*;
import java.io.*;

public class Main {

    static int N, K, dest;
    static int[] costs, linkedCount;
    static ArrayList<Integer>[] list;

    static int search() {
        Queue<Integer> que = new LinkedList<>();
        int[] sums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            sums[i] = costs[i];
            if (linkedCount[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int child : list[cur]) {
                sums[child] = Math.max(sums[child], sums[cur]+costs[child]);
                linkedCount[child]-=1;

                if (linkedCount[child] == 0) que.add(child);
            }
        }

        return sums[dest];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            String[] countsInput = reader.readLine().split(" ");
            String[] costsInput = reader.readLine().split(" ");

            N = Integer.parseInt(countsInput[0]); // 건물 개수
            K = Integer.parseInt(countsInput[1]); // 규칙의 개수

            costs = new int[N+1];
            for (int i = 0; i < N; i++) {
                costs[i+1] = Integer.parseInt(costsInput[i]);
            }

            list = new ArrayList[N+1];
            linkedCount = new int[N+1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                String[] input = reader.readLine().split(" ");

                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);

                list[X].add(Y);
                linkedCount[Y]++;
            }

            dest = Integer.parseInt(reader.readLine());

            writer.write(search()+"\n");
            writer.flush();
        }
    }
}

