import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] linkedCount, sums, costs;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        linkedCount = new int[N];
        sums = new int[N];
        costs = new int[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");

            costs[i] = Integer.parseInt(inputs[0]);
            for (int j = 1; j < inputs.length-1; j++) {
                int connected = Integer.parseInt(inputs[j])-1;
                list[connected].add(i);
                linkedCount[i]+=1;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            sums[i] = costs[i];
            if (linkedCount[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int child : list[cur]) {
                sums[child] = Math.max(sums[child], costs[child] + sums[cur]);
                linkedCount[child]-=1;
                if (linkedCount[child]==0) que.add(child);
            }
        }

        for (int sum : sums) {
            writer.write(sum + "\n");
        }
        writer.flush();
    }
}

