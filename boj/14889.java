import java.util.*;

// 1. DFS로 두 팀을 나눈다.
// 2. 두 팀을 배열로 나타낸다.
// 3. 두 팀의 능력 차를 구한다.

public class Main {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] check;

    public static int sum(int[] a) {
        int res = 0;
        int len = N / 2;
        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                res += arr[a[i]][a[j]] + arr[a[j]][a[i]];
            }
        }

        return res;
    }

    public static void teams() {
        int[] s = new int[N / 2 + 1], l = new int[N / 2 + 1];
        int sId = 1, lId = 1;

//        for (int i = 1; i<= N; i++) System.out.printf("%d ", check[i] ? 1 : 0);
//        System.out.printf("\n");

        for (int i = 1; i <= N; i++) {
            if (check[i]) { // s
                s[sId++] = i;
            } else { // l
                l[lId++] = i;
            }
        }

        int sRes = sum(s);
        int lRes = sum(l);

        if (ans > Math.abs(sRes - lRes)) ans = Math.abs(sRes - lRes);
    }

    public static void dfs(int start, int len) {
        if (N / 2 == len) {
            teams();
        }
        else {
            for (int i = start + 1; i <= N; i++) {
                if (check[i]) continue;
                check[i] = true;
                dfs(i, len + 1);
            }
        }
        check[start] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);

        System.out.printf("%d", ans);
    }
}