import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    static int size, arr[][];
    public static void solve(int depth) {

        // 처음에는 조건문을 0부터 size까지(위에서 아래로) 탐색하려고 했는데
        // for에 조건을 어떻게 달아줘야 할지 모르겠어서 밑에서 위로 탐색하는 걸로 바꿨다.
        // dp 문제는 재귀 쓰면 보통 시간 초과가 나는 것 같다.
        // 담부터는 재귀 말고 for문에서 끝내는 걸 생각해보자.

        for (int i = depth - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] > arr[i][j + 1]) {
                    arr[i - 1][j] += arr[i][j];
                }
                else
                    arr[i - 1][j] += arr[i][j + 1];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int k = i + 1; k < size; k++) {
                arr[i][k] = -1;
            }
        }

        solve(size);

        System.out.println(arr[0][0]);
    }
}