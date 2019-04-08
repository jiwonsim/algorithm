import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long arr[];
    public static void calculate() {
        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[1001];
        calculate();
        System.out.println(arr[N]);
    }
}