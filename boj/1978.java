import java.util.*;

public class Main {
    static int[] arr = new int[1001];

    static void init() {
        arr[1] = -1;
        for (int i = 2; i <= 1000; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= 1000; i++) {
            for (int j = i + i; j <= 1000; j += i) {
                if (arr[j] == 0) continue;
                arr[j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();

        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (arr[input] != -1) count++;
        }

        System.out.println(count);
    }
}