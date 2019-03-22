import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }


    public static int check(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result += gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long result = 0; //int로 받으면 모자르다. long으로 받아줘야 한다.
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    result += gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
                }
            }
            System.out.println(result);
        }
    }
}