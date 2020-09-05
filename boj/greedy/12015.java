import java.util.*;

public class Main {
    static int lower_bound(int end, int value, int[] A) {
        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] >= value) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n + 1];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if (in > A[len]) {
                A[++len] = in;
            }
            else {
                A[lower_bound(len, in, A)] = in;
            }
        }

        System.out.printf("%d", len);
    }
}