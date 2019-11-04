import java.util.*;

public class Main {

    static int N;
    static int[] cost, ans;

    static void initCost() {
         ans[0] = 0;
         ans[1] = cost[1];

         for (int i = 2; i <= N; i++) {
             ans[i] = cost[i];
             if (ans[i] < ans[i - 1]) {
                 ans[i] = ans[i - 1];
             }
             for (int j = 1; j <= i; j++) {
                 if (ans[i] < cost[i - j] + ans[j]) {
                     ans[i] = cost[i - j] + ans[j];
                 }
             }
         }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        cost = new int[N + 1];
        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = sc.nextInt();
        }

        initCost();
        System.out.printf("%d\n", ans[N]);


    }
}