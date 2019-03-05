import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int N, M, V;
    public static int x, y;

    public static int[][] adj = new int[1001][1001];
    public static boolean[] check = new boolean[10001];

    public static void DFS(int start) {
        check[start] = true;
        System.out.print(start + " ");
        for(int i=0; i< adj[start].length; i++) {

            if(adj[start][i] == 1 && check[i] == false) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        check[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int next = q.peek();
            q.poll();
            System.out.print(next + " ");
            for (int i = 0; i < adj[next].length; i++) {
                if(adj[next][i] == 1 && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        for(int i=1; i<=M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        DFS(V);

        for(int i=1; i<=N; i++) {
            check[i] = false;
        }

        System.out.println();

        BFS(V);
    }
}
