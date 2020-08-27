import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] lans = new long[K];
        long MAX = 0;
        for (int i = 0; i < K; i++) {
            lans[i] = sc.nextLong();
            if (MAX < lans[i]) MAX = lans[i];
        }

        long MIN = 1;
        while (MIN <= MAX) {
            long mid = (MAX + MIN) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += lans[i] / mid;
            }

            if (sum >= N) MIN = mid + 1;
            else MAX = mid - 1;
        }

        System.out.println(MAX);
    }
}