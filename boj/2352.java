import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] tmp = new int[n + 1];
        tmp[1] = 1;
        int MAX = 1;


        for (int i = 2; i <= n; i++) {
            tmp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && tmp[j] + 1 > tmp[i]) {
                    tmp[i] = tmp[j] + 1;
                }
            }

            if (MAX < tmp[i]) MAX = tmp[i];
        }

//        for (int i = 1; i <= n; i++) System.out.printf("%d ", tmp[i]);

        System.out.printf("%d", MAX);
    }
}