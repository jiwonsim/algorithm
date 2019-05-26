class Solution {
    boolean visited[][] ;
    void dfs(int index, int n, int computers[][]) {
        for (int i = 0; i < n; i++) {
            if (visited[index][i]) continue;
            if (computers[index][i] == 0) continue;
            visited[index][i] = true;
            visited[i][index] = true;
            dfs(i, n, computers);
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (visited[i][i]) continue;
            dfs(i, n, computers);
            answer++;
        }


        return answer;
    }
}