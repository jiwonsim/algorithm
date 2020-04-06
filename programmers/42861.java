import java.util.*;

class Edge implements Comparable<Edge> {
    int v1, v2, w;

    Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    @Override
    public int compareTo(Edge target) {
        return this.w - target.w;
    }
}

class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return true;
        return false;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // initialize PriorityQueue for sorting by weight between two vertexs
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        // initialize parent array
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // find whether or not is cyclic root
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            boolean isCyclic = isSameParent(cur.v1, cur.v2);
            if (!isCyclic) { // there is no cycle
                answer += cur.w;
                union(cur.v1, cur.v2); // connect each parent
            }
        }

        return answer;
    }
}