import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        long MAX = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] > MAX) MAX = arr[i];
        }

        int M = sc.nextInt();

        Arrays.sort(arr);
        long max = M, min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] * (N - i) <= max) max -= arr[i];
            else {
                min = max / (N - i);
                break;
            }
        }

        if (min == 0) {
            if (arr[N - 1] > M) min = -1;
            else min = arr[N - 1];
        }

        System.out.printf("%d", min);

    }
}