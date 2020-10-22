import java.util.*;
import java.io.*;

public class Main {

    static int N, M, start, end;
    static int[] linkedCount, sums;
    static int[][] costs;
    static ArrayList<Integer>[] list, reversedList;

    static int searchMeetingTime() {
        // 탐색 시작
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int child : list[cur]) {
                sums[child] = Math.max(sums[child], sums[cur]+costs[cur][child]);
                linkedCount[child]-=1;
                if (linkedCount[child] == 0) que.add(child);
            }
        }
        return sums[end];
    }

    static int countNonstopRoads() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int count = 0;
        que.add(end);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int ele : reversedList[cur]) {
                if (sums[ele] == sums[cur]-costs[ele][cur]) {
                    if (!visited[ele]) que.add(ele);
                    count += 1;
                    visited[ele] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        linkedCount = new int[N+1];
        sums = new int[N+1];
        costs = new int[N+1][N+1];
        list = new ArrayList[N+1];
        reversedList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reversedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = reader.readLine().split(" ");

            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            linkedCount[e]+=1;
            list[s].add(e);
            reversedList[e].add(s);
            costs[s][e] = c;
        }
        String[] input = reader.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        writer.write(searchMeetingTime() + "\n" + countNonstopRoads());
        writer.flush();
    }
}

