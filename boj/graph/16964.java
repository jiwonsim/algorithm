import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] maps;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer> result;
    static int[] inputAnswer, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화
        N = Integer.parseInt(br.readLine());

        maps = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();
        cost = new int[N + 1];
        inputAnswer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        // 입력
        for (int i = 0; i < N - 1; i++) {
            String[] in = br.readLine().split(" ");

            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);

            maps[from].add(to);
            maps[to].add(from);
        }

        // 첫번째 인자가 1이 아니면 false
        String[] input = br.readLine().split(" ");
        if (!input[0].equals("1")) {
            System.out.println("0");
            return;
        }

        // 가중치 입력
        for (int i = 1; i <= N; i++) {
            inputAnswer[i] = Integer.parseInt(input[i - 1]);
            cost[inputAnswer[i]] = i;
        }

        // 가중치로 정렬
        for (int i = 1; i <= N; i ++) {
            Collections.sort(maps[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (cost[o1] == cost[o2]) return 0;
                    else if (cost[o1] < cost[o2]) return -1;
                    return 1;
                }
            });
        }

        // 1에서부터 시작
        find(1);

        // 검사
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) != Integer.parseInt(input[i])) {
                System.out.printf("0");
                return;
            }
        }
        System.out.printf("1");
    }

    // DFS
    static void find(int num) {
        if (visited[num]) return;

        visited[num] = true;
        result.add(num);
        for (int ele : maps[num]) {
            find(ele);
        }
    }
}