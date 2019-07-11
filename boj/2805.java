import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] tree = new long[N];
        long MAX = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (MAX < tree[i]) MAX = tree[i];
        }

        long left = 0, right = MAX, res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) sum += tree[i] - mid;
            }

            if (sum >= M) {
                if (res < mid) res = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.printf("%d ", res);
    }
}