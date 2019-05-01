//참고 : https://spillmoon.tistory.com/176

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][3];
        int r, g, b;
        arr[0][0] = sc.nextInt();
        arr[0][1] = sc.nextInt();
        arr[0][2] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            r = sc.nextInt();
            g = sc.nextInt();
            b = sc.nextInt();

            arr[i][0] = r + Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] = g + Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] = b + Math.min(arr[i-1][0], arr[i-1][1]);
        }

        System.out.println(Math.min(arr[N-1][0], Math.min(arr[N-1][1], arr[N-1][2])));
        sc.close();
    }
}