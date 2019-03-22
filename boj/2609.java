import java.util.Scanner;

public class Main {
    static int N, M;

//    public static int gcd(int N, int M) {
//        int max = 1;
//        for (int i = 1; i < N; i++) {
//            if (N % i == 0 && M % i == 0) {
//                max = i;
//            }
//        }
//        return max;
//    }

    public static int gcd(int N, int M) {
        int mod = N % M;
        while (mod > 0) {
            N = M;
            M = mod;
            mod = N % M;
        }
        return M;
    }

    public static int lcm(int N, int M, int gcd) {
        return (N * M) / gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int gcd = gcd(Math.max(N, M), Math.min(N, M));
        System.out.println(gcd);
        int lcm = lcm(N, M, gcd);
        System.out.println(lcm);
    }
}