import java.util.*;

/*
1. 첨에는 DFS로 풀었다가 죄다 틀려버림 ^.^
2. BFS로 풀었지만 인접행렬을 사용해서 메모리 초과
3. 인접행렬보다 인접리스트가 더 빠르다! 제한사항에 node의 개수는 20,000개라고 했기 떄문에
    인접행렬은 20,000 * 20,000 이 안된다! 따라서 인접리스트를 이용하자. (by 희성)
*/

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0] - 1).add(edge[i][1] - 1);
            list.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }

        int count[] = new int[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        int MAX = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if (count[next] != 0) continue;
                if (next == 0) continue;
                count[next] = count[cur] + 1;
                MAX = Math.max(MAX, count[next]);
                q.add(next);
            }
        }

        for (int i = 1; i < count.length; i++) {
            if (MAX == count[i]) answer++;
        }

        return answer;
    }
}
