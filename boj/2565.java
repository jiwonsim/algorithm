import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[501];

        for (int i = 1; i <= N; i++) {
            int idx = sc.nextInt();
            int toId = sc.nextInt();

            arr[idx] = toId;
        }

        int[] sizes = new int[501];
        sizes[0] = 1;
        int MAX = 1;

        for (int i = 1; i < 501; i++) {
            if (arr[i] == 0) continue;

            sizes[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) continue;
                if (sizes[j] + 1 > sizes[i]) sizes[i] = sizes[j] + 1;
            }

            MAX = Math.max(sizes[i], MAX);
        }

        System.out.printf("%d", N - MAX);
    }
}

