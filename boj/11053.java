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
        sizes[0] = 1;
        int MAX = 1;


        for (int i = 1; i < N; i++) {
            sizes[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] <= A[j]) continue;
                if (sizes[j] + 1 > sizes[i]) {
                    sizes[i] = sizes[j] + 1;
                }
            }

            if (MAX < sizes[i]) {
                MAX = sizes[i];
            }
        }

        System.out.printf("%d", MAX);

    }
}