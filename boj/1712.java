import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if (C == B) {
            System.out.printf("-1");
        }
        else {
            long sum = A / (C - B);
            if (sum < 0) System.out.printf("-1");
            else System.out.printf("%d\n", sum + 1);
        }
    }
}