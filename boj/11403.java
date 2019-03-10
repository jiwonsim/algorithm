import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M[][];
    static int res[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = new int[N][N];
        res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[N];

            q.offer(i);

            while (!q.isEmpty()) {
                int val = q.poll();

                for (int j = 0; j < N; j++) {
                    if (visited[j] == false && M[val][j] == 1) {
                        q.offer(j);
                        visited[j] = true;
                        res[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}