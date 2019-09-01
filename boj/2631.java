import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sizes = new int[N];
        sizes[0] = 1;
        int MAX = 1;

        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) continue;
                if (sizes[j] + 1 >  sizes[i]) {
                    sizes[i] = sizes[j] + 1;
                }
            }

            MAX = Math.max(sizes[i], MAX);
        }

        System.out.printf("%d", N - MAX);

    }
}