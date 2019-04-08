import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
나는 '1,2,3 더하기' 문제를 dp로도 풀었고 dfs로도 풀었따.
'1,2,3 더하기3'은 dfs로 풀거나 dp로 풀면 시간초과가 난다.
시간초과가 날 땐 항상 배열에 몽땅 저장한 담에 출력해오는 걸루
범위를 주의하라
 */

public class Main {
    static long arr[];
    public static void calculate() {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i <= arr.length - 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new long[1000001];
        calculate();
        while (N-- != 0) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(arr[input]);
        }
    }
}