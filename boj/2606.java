import java.util.*;

public class Main {
    static int cnt = 0;

    static void search(int row, int n, int[][] net, boolean[] visited) {
        cnt++;

        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (visited[i]) continue;
            if (net[row][i] != 1) continue;
            visited[i] = true;
            search(i, n, net, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer = sc.nextInt(), network = sc.nextInt();
        int[][] net = new int[computer][computer];

        for (int i = 0; i < network; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            net[x][y] = 1;
            net[y][x] = 1;
        }

        boolean[] visited = new boolean[computer];

        visited[0] = true;
        for (int i = 1; i < computer; i++) {
            if (net[0][i] != 1) continue;
            if (visited[i]) continue;
            visited[i] = true;
            search(i, computer, net, visited);
        }

        System.out.printf("%d\n", cnt);
    }
}