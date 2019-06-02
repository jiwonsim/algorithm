import java.util.*;

class Pair {
    int node, count;
    Pair(int node, int count) {
        this.node = node;
        this.count = count;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[][] arr = new int[n][n];
        int[] count = new int[n];
//        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < edge.length; i++) {
            arr[edge[i][0] - 1][edge[i][1] - 1] = 1;
            arr[edge[i][1] - 1][edge[i][0] - 1] = 1;
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 1) {
//                visited[0][i] = true;
//                visited[i][0] = true;
                count[i]++;
                q.add(new Pair(i, 1));
            }
        }

        int MAX = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < n; i++) {
//                if (visited[p.node][i]) continue;
                if (count[i] != 0) continue;
                if (arr[p.node][i] == 0) continue;
//                visited[p.node][i] = true;
//                visited[i][p.node] = true;
                count[i] = count[p.node] + 1;
                MAX = Math.max(MAX, count[i]);
                q.add(new Pair(i, count[i]));
            }
        }

        for (int i = 1; i < count.length; i++) {
            if (MAX == count[i]) answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int[][] vertex = {{1, 2}, {1, 3}, {1, 4}, {4, 5}, {1, 5}, {5, 6}, {6, 3}, {6, 7}, {6, 8}, {6, 9}};
        System.out.printf("%d ", s.solution(9, vertex));
    }
}