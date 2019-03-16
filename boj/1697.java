import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int checked[];

    public static int bfs() {
        int second = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                N = q.poll();

                if (N == M) return second;
                if (N>0 && checked[N-1] == 0) {
                    q.offer(N-1);
                    checked[N-1] = 1;
                }
                if (N<100000 && checked[N+1] == 0) {
                    q.offer(N+1);
                    checked[N+1] = 1;
                }
                if (N*2 < 100000 && checked[N*2] == 0) {
                    q.offer(N*2);
                    checked[N*2] = 1;
                }
            }
            second++;
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        checked = new int[100001];

        System.out.println(bfs());
    }
}