import java.util.Scanner;

public class Main {

    public static int findPrimeNumber(int arr[]) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) continue;
            for (int j = 2; j < arr[i]; j++) {
                flag = true;
                if (arr[i] % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findPrimeNumber(arr));
    }
}