import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] linkedCount;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력과 초기화
        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        linkedCount = new int[N+1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] input = reader.readLine().split(" ");

            for (int j = 1; j < input.length-1; j++) {
                int before = Integer.parseInt(input[j]);
                int after = Integer.parseInt(input[j+1]);

                list[before].add(after);
                linkedCount[after]+=1;
            }
        }

        // 탐색 시작
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (linkedCount[i] == 0) que.add(i);
        }

        ArrayList<Integer> answers = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.poll();
            answers.add(cur);

            for (int child : list[cur]) {
                linkedCount[child]-=1;
                if (linkedCount[child] == 0) que.add(child);
            }
        }

        if (answers.size() != N) writer.write("0");
        else {
            for (int answer : answers) {
                writer.write(answer + "\n");
            }
        }
        writer.flush();
    }
}

