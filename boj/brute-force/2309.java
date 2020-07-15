import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 모든 합을 다 구한 다음에 모든 합에서 100을 뺀 값이 0일 때 출력

public class Main {
    static int visited[];
    public static int sum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] bruteForce(int arr[]) {
        boolean flag = true;
        for (int i = 0 ; i < 9; i++) {
            if (flag == false) break;
            for (int j = 0; j < 9; j++) {
                if (i == j) continue;
                if (sum(arr) - arr[i] - arr[j] == 100) {
                    flag = false;
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
        }

        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[9];
        visited = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result[] = bruteForce(arr);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) continue;
            System.out.println(arr[i]);
        }
    }
}