import java.util.*; 

class Solution {
    ArrayList<Integer>[] list; 
    
    boolean[] visited; 
    int maxDepth, leafNode, count; 
    
    void dfs(int index, int depth) {
        if (visited[index]) return; 
        visited[index] = true; 
        
        if (depth >= maxDepth) {
            if (depth > maxDepth) {
                count = 1; 
                maxDepth = depth; 
                leafNode = index; 
            }
            else count+=1; 
        }
        
        for (int element : list[index]) {
            dfs(element, depth+1); 
        }
    }
    
    void go(int index, int n) {
        visited = new boolean[n+1];
        maxDepth = 0; 
        count = 0; 
        
        dfs(index, 0); 
    }
    
    public int solution(int n, int[][] edges) {
        int answer = 0;
        
        // 초기화 
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>(); 
        
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]); 
            list[edge[1]].add(edge[0]); 
        }
        
        go(1, n); 
        go(leafNode, n);
        
        if (count > 1) return maxDepth; 
        go(leafNode, n); 
        if (count > 1) return maxDepth; 
        return maxDepth-1; 
    }
}
