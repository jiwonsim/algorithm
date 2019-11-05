import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] pinaryNum = new long[N + 1][2];
        pinaryNum[1][0] = 0;
        pinaryNum[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            pinaryNum[i][0] = pinaryNum[i - 1][0] + pinaryNum[i - 1][1];
            pinaryNum[i][1] = pinaryNum[i - 1][0];
        }

        System.out.printf("%d", pinaryNum[N][0] + pinaryNum[N][1]);
    }
}