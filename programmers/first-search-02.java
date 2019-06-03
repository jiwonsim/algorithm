import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                answer++;
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int j = 0; j < list.get(cur).size(); j++) {
                    int next = list.get(cur).get(j);
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return answer;
    }
}