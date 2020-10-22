import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] linkedCount, costs, sums;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력과 초기화
        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);

        linkedCount = new int[N+1];
        list = new ArrayList[N+1];
        costs = new int[N+1];
        sums = new int[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String[] input = reader.readLine().split(" ");

            costs[i] = Integer.parseInt(input[0]);
            for (int j = 2; j < input.length; j++) {
                int to = Integer.parseInt(input[j]);
                list[i].add(to);
                linkedCount[to]+=1;
            }
        }

        // 탐색 시작
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            sums[i] = costs[i];
            if (linkedCount[i] == 0) que.add(i);
        }

        ArrayList<Integer> answers = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.poll();
            answers.add(cur);

            for (int child : list[cur]) {
                sums[child] = Math.max(sums[child], sums[cur]+costs[child]);
                linkedCount[child]-=1;
                if (linkedCount[child] == 0) que.add(child);
            }
        }

        int answer = 0;
        for (int sum : sums) {
            answer = Math.max(answer, sum);
        }

        writer.write(answer + "\n");
        writer.flush();
    }
}

