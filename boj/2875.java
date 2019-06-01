import java.util.*;

// 틀린 이유 : 인턴십이 강제라는 걸 고려안함

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();

        int sum = N + M;
        int count = 0;
        while (true) {
            sum -= 3;
            if (sum < K) break;
            if (N < 2 || M < 1) break;
            N -= 2;
            M -= 1;

            count++;
        }

        System.out.printf("%d", count);
    }
}