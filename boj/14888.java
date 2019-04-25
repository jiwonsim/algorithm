//참고한 사이트 : https://suriisurii.tistory.com/11

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    static boolean visited[];
    static int arr[];
    static int cal[];

    public static void solve (int cur, int plus, int sub, int multi, int div, int sum) {
        if (cur == N) {
//            System.out.println("?!?! " + sum);
            MIN = Math.min(sum, MIN);
            MAX = Math.max(sum, MAX);
            return;
        }

//        System.out.println("잉");
        if (plus < cal[0])
            solve(cur + 1, plus + 1, sub, multi, div, sum + arr[cur]);
        if (sub < cal[1])
            solve(cur + 1, plus, sub + 1, multi, div, sum - arr[cur]);
        if (multi < cal[2])
            solve(cur + 1, plus, sub, multi + 1, div, sum * arr[cur]);
        if (div < cal[3])
            solve(cur + 1, plus, sub, multi, div + 1, sum / arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new int[4];
        visited = new boolean[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, 0, 0, 0, 0, arr[0]);

        System.out.println(MAX);
        System.out.println(MIN);

    }
}