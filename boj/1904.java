import java.util.Scanner;

public class Main {
    public static int recursion(int k) {
        // 재귀는 시간초과 남
        if (k <= 3) return k;

        return recursion(k - 1) % 15746 + recursion(k - 2) % 15746;
    }

    public static int memorzation(int k, int[] mem) {
        if (k <= 3) return k;
        if (mem[k] != 0) return mem[k];
        mem[k] = memorzation(k - 1, mem) % 15746 + memorzation(k - 2, mem) % 15746;
        return mem[k] % 15746;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1000001];
        int res;
//        int res = fib(N) % 15746;
        res = memorzation(N, arr);
        System.out.printf("%d", res);
    }
}