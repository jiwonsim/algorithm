import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int k;
    static int S[];
    static int visited[];
    static int height;

    public static void dfs(int height, int start) {
        if (height == 6) {
            for (int i = 0; i< k; i++) {
                if (visited[i] == '\0') break;
                System.out.print(visited[i] + " ");
            }
            System.out.println();
            return;
        }
        else {
            for (int i = start; i < k; i++) {
                visited[height] = S[i];
                dfs(height+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) return;

            S = new int[k];
            for (int i = 0; i < k; i++){
                S[i] = sc.nextInt();
            }
            visited = new int[k];
            dfs(height, 0);
            System.out.println();
        }
    }
}