import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] sizes = new int[N];
        int MAX = A[0];
        sizes[0] = A[0];

        for (int i = 1; i < N; i++) {
            sizes[i] = A[i];

            for (int j = 0; j < i; j++) {
                if (A[j] >= A[i]) continue;
                if (sizes[j] + A[i] > sizes[i]) {
                    sizes[i] = sizes[j] + A[i];
                }
            }

            if (MAX < sizes[i]) MAX = sizes[i];
        }

        System.out.printf("%d", MAX);
    }
}