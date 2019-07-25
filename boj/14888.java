import java.util.Scanner;

public class Main {
    static int[] op, A;
    static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
    public static void solve(int plus, int sub, int mul, int div, int sum, int cnt) {
        if (cnt >= N) {
            if (sum > MAX) MAX = sum;
            if (sum < MIN) MIN = sum;
            return;
        }

        int tmp;

        if (plus > 0) {
            tmp = sum + A[cnt];
            solve(plus - 1, sub, mul, div, tmp, cnt + 1);
        }
        if (sub > 0) {
            tmp = sum - A[cnt];
            solve(plus, sub - 1, mul, div, tmp, cnt + 1);
        }
        if (mul > 0) {
            tmp = sum * A[cnt];
            solve(plus, sub, mul - 1, div, tmp, cnt + 1);
        }
        if (div > 0) {
            tmp = sum / A[cnt];
            solve(plus, sub, mul, div - 1, tmp, cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        op = new int[4];

        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) op[i] = sc.nextInt();

        solve(op[0], op[1], op[2], op[3], A[0], 1);

        System.out.printf("%d\n%d\n", MAX, MIN);

    }
}