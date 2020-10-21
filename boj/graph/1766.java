import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력과 초기화
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        ArrayList<Integer>[] list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] childCount = new int[N+1];

        for (int i = 0; i < M; i++) {
            String[] related = reader.readLine().split(" ");
            int A = Integer.parseInt(related[0]);
            int B = Integer.parseInt(related[1]);

            list[A].add(B);
            childCount[B]+=1;
        }

        // 탐색 시작
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (childCount[i] == 0) que.add(i);
        }

        ArrayList<Integer> answers = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.poll();
            answers.add(cur);

            for (int child : list[cur]) {
                childCount[child]-=1;

                if (childCount[child] == 0) que.add(child);
            }
        }

        for (int answer : answers) {
            writer.write(answer + " ");
        }
        writer.flush();
    }
}
