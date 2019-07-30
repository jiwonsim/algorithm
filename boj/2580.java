import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int SIZE = 9;
    static int[][] sudoku = new int[SIZE][SIZE];
    static List<Pair> list = new ArrayList<>();
    static boolean isPrinted = false;

    public static void printSudoku() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%d ", sudoku[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static boolean isPossible(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (i != y && sudoku[x][i] == val) return false;
            if (i != x && sudoku[i][y] == val) return false;
        }

        int sx = x / 3 * 3;
        int sy = y / 3 * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (i == x && j == y) continue;
                if (val == sudoku[i][j]) return false;
            }
        }

        return true;
    }

    public static void solve(int cnt, int index) {
        if (isPrinted) return;
        if (cnt == list.size()) {
            printSudoku();
            isPrinted = true;
            return;
        }

        Pair cur = list.get(index);

        for (int i = 1; i <= SIZE; i++) {
            if (!isPossible(cur.x, cur.y, i)) continue;
            sudoku[cur.x][cur.y] = i;
//                System.out.printf("%d %d %d : %d\n", x, y, i, depth);
            solve(cnt + 1, index + 1);
            sudoku[cur.x][cur.y] = 0;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sudoku[i][j] = sc.nextInt();
                if (sudoku[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }

        solve(0, 0);
    }
}