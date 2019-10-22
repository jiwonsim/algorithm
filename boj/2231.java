import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int res = 0;
        for (int i = 1; i <= N; i++) {
            int M = i;
            String strM = String.valueOf(M);
            for (int j = 0; j < strM.length(); j++) {
                M += strM.charAt(j) - '0';
            }

            if (M == N) {
                res = i;
                break;
            }
        }

        System.out.printf("%d", res);
    }
}