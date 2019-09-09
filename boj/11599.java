import java.util.*;

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static boolean[][] visited;

    static int[] toX = {0, 0, 1, -1}, toY = {1, -1, 0, 0};
    static List<Pair> list;

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int goX = toX[i] + x;
            int goY = toY[i] + y;

            if (goX < 0 || goY < 0 || goX >= 12 || goY >= 6) continue;
            if (visited[goX][goY]) continue;
            if (arr[x][y] != arr[goX][goY]) continue;
            list.add(new Pair(goX, goY));
            visited[goX][goY] = true;
            dfs(goX, goY);
        }
    }

    public static void move() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11 - 1; i >= 0; i--) {
                if (arr[i][j] == 0) continue;
                for (int k = 12 - 1; k > i; k--) {
                    if (arr[k][j] == 0) {
                        arr[k][j] = arr[i][j];
                        arr[i][j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        arr = new int[12][6];
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            String in = sc.next();
            for (int j = 0; j < 6; j++) {
                int num = -1;
                if (in.charAt(j) == 'R') num = 1;
                else if (in.charAt(j) == 'G') num = 2;
                else if (in.charAt(j) == 'B') num = 3;
                else if (in.charAt(j) == 'P') num = 4;
                else if (in.charAt(j) == 'Y') num = 5;
                else num = 0;

                arr[i][j] = num;
            }
        }


        while (true) {
            boolean flag = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] == 0) continue;
                    list = new ArrayList<>();
                    dfs(i, j);
                    if (list.size() >= 4) {
                        flag = true;
                        for (Pair p : list) {
                            arr[p.x][p.y] = 0;
                        }
                    }
                }
            }

            if (flag) {
                answer++;
            }
            else break;

            move();
        }

        System.out.printf("%d", answer);

    }
}