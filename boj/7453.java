import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i  < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        long[] ab = new long[n * n];
        long[] cd = new long[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[index] = a[i] + b[j];
                cd[index] = c[i] + d[j];
                index++;
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long res = 0;
        int left, right;

        for (int i = 0; i < ab.length; i++) {
            left = 0; right = n * n;

            while (left < right) {
                int mid = (left + right) / 2;

                if (ab[i] + cd[mid] <= 0) left = mid + 1;
                else right = mid;
            }

            int ub = right;
            left = 0; right = n * n;

            while (left < right) {
                int mid = (left + right) / 2;

                if (ab[i] + cd[mid] < 0) left = mid + 1;
                else right = mid;
            }

            int lb = right;

            res += (long)(ub - lb);
        }

        System.out.printf("%d\n", res);
    }
}