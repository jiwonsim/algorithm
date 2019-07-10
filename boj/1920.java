import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> A = new HashSet<>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }

        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        for (int b : B) {
            if (A.contains(b)) System.out.printf("1\n");
            else System.out.printf("0\n");
        }
    }
}