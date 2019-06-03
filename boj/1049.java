import java.util.*;

// 내가 놓쳤던 것 : 패키지와 낱개를 같은 브랜드에서 살 필요는 없다!

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int MIN = Integer.MAX_VALUE;
        int[] pack = new int[M], ind = new int[M];
        for (int i = 0; i < M; i++) {
            pack[i] = sc.nextInt();
            ind[i] = sc.nextInt();

        }

        Arrays.sort(pack);
        Arrays.sort(ind);

        int price1, price2, price3;

        price1 = pack[0] * (N / 6 + 1);
        price2 = pack[0] * (N / 6) + ind[0] * (N % 6);
        price3 = ind[0] * N;

        MIN = Math.min(price1, price2);
        MIN = Math.min(MIN, price3);


        System.out.printf("%d ", MIN);
    }
}