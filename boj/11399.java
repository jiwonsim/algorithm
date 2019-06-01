import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);
        int sum = 0, before = 0;
        for (int i : arr) {
            before += i;
            sum += before;
        }

        System.out.printf("%d", sum);

        /*
        i : 2 5 1 4 3
        t : 1 2 3 3 4

        1 = 1
        1 + 2 = 3
        1 + 2 + 3 = 6
        1 + 2 + 3 + 3 = 9
        1 + 2 + 3 + 3 + 4 = 13
         */
    }
}