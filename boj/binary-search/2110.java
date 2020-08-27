import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = sc.nextInt();
        }

        Arrays.sort(homes);

        int left = 1;
        int right = homes[N - 1] - homes[0];

        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int start = homes[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (homes[i] - start >= mid) {
                    cnt++;
                    start = homes[i];
                }
            }

            if (cnt >= C) {
                res = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.printf("%d", res);
    }
}