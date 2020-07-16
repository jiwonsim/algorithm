import java.util.Scanner;

public class Main {
    public static int calculateYear(int E, int S, int M) {
        int e = 1, s = 1, m = 1;
        for (int i = 1; ; i++) {
            if (e == E && s == S && m == M) {
                return i;
            }

            e++; s++; m++;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }
    }
    public static void main(String[] args) {
        int E, S, M;
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        System.out.println(calculateYear(E, S, M));
    }
}