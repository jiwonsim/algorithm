import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int moneys[] = new int[N];
        for (int i = 0; i < N; i++) {
            moneys[i] = sc.nextInt();
        }

        int count = 0, money;
        for (int i = moneys.length - 1; i >= 0; i--) {
            money = moneys[i];
            if (money > K) continue;
            while (money <= K) {
                count += K / money;
                K = K % money;
            }
        }

        System.out.printf("%d ", count);

        /*
        10 4200

        1000 * 4
        100 * 2

        총 6개!
         */
    }
}