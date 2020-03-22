import java.util.*;

public class Main {
    static int M, N;
    static int[] arr;

    static void init() {
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i + i; j <= N; j += i) {
                if (arr[j] == 0) continue;
                arr[j] = -1;
            }
        }
    }

    static void findPrime() {
        for (int i = M; i <= N; i++) {
            if (i == 1) continue;
            if (arr[i] == -1) continue;
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N + 1];

        init();
        findPrime();
    }
}