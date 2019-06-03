import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int rope[] = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }

        Arrays.sort(rope);

        int max = -1;
        for (int i = N - 1; i >= 0; i--) {
            max = Math.max(max, rope[i] * (N - i));
        }

        System.out.printf("%d", max);
    }
}