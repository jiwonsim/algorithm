import java.io.*;
import java.util.*;

public class Main {

    static int[] numbers;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void solve(int index, int plus, int minus, int multi, int divide, int sum) {

        if (index >= numbers.length - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if (plus > 0) {
            solve(index + 1, plus - 1, minus, multi, divide, sum + numbers[index + 1]);
        }
        if (minus > 0) {
            solve(index + 1, plus, minus - 1, multi, divide, sum - numbers[index + 1]);
        }
        if (multi > 0) {
            solve(index + 1, plus, minus, multi - 1, divide, sum * numbers[index + 1]);
        }
        if (divide > 0) {
            solve(index + 1, plus, minus, multi, divide - 1, sum / numbers[index + 1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        int[] operCnt = new int[4];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operCnt[i] = Integer.parseInt(input[i]);
        }

        solve(0, operCnt[0], operCnt[1], operCnt[2], operCnt[3], numbers[0]);
        System.out.println(max + "\n" + min);
    }
}