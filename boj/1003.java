import java.util.*;

// Scanner(140ms)로 하나 BufferedReader(108ms)로 하나 정답은 된다!
// Recursion이 아닌 Memorization을 쓰는 것이 포인트!

public class Main {
    static int[] memZero = new int[1000001];
    static int[] memOne = new int[1000001];
    public static int countZero(int k) {
        if (k == 0) return 1;
        if (k == 1) return 0;

        if (memZero[k] != 0) return memZero[k];

        memZero[k] = countZero(k - 1) + countZero(k - 2);

        return memZero[k];
    }

    public static int countOne(int k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        if (memOne[k] != 0) return memOne[k];

        memOne[k] = countOne(k - 1) + countOne(k - 2);

        return memOne[k];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int zero, one;
        while (T-- != 0) {
            int k = sc.nextInt();
            zero = countZero(k);
            one = countOne(k);
            System.out.printf("%d %d \n", zero, one);
        }
    }
}