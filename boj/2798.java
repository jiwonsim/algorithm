import java.util.*;

public class Main {
    static int N, M, result = Integer.MIN_VALUE;
    static int[] cards;

    static void search(int start, int sum, int count) {
        if (count == 3) {
            if (sum <= M) {
                result = Math.max(result, sum);
            }
            return;
        }

        for (int i = start + 1; i < N; i++) {
            search(i, sum + cards[i], count + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N];
        for (int i = 0; i < N; i++) cards[i] = sc.nextInt();

        Arrays.sort(cards);

        for (int i = 0; i < cards.length; i++) {
            search(i, cards[i], 1);
        }

        System.out.printf("%d\n", result);

    }
}