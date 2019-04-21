import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean checkAnswer[];
    static int A, B, C, arr[] = new int[3 + 1];
    static boolean visited[][][];
    public static void solve(int a, int b, int c) {
        if (a == 0)
            checkAnswer[c] = true;

        if (visited[a][b][c]) return;

        visited[a][b][c] = true;

        // c -> b
        if (b + c > arr[2]) {
            //다 담을 수 없음
            solve(a, arr[2], (b + c) - arr[2]);
        }
        else {
            //다 담을 수 있음
            solve(a, b + c, 0);
        }
        // c -> a
        if (a + c > arr[1]) {
            solve(arr[1], b, (a + c) - arr[1]);
        }
        else {
            solve(a + c, b, 0);
        }
        // a -> b
        if (a + b > arr[2]) {
            solve((a + b) - arr[2], arr[2], c);
        }
        else {
            solve(0, (a + b), c);
        }
        // a -> c
        if (a + c > arr[3]) {
            solve((a + c) - arr[3], b, arr[3]);
        }
        else {
            solve(0, b, (a + c));
        }
        // b -> a
        if (a + b > arr[1]) {
            solve(arr[1], (a + b) - arr[1], c);
        }
        else {
            solve((a + b), 0, c);
        }
        // b -> c
        if (b + c >  arr[3]) {
            solve(a, (b + c) - arr[3], arr[3]);
        }
        else {
            solve(a, 0, (b + c));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr[1] = A;
        arr[2] = B;
        arr[3] = C;
        checkAnswer = new boolean[C + 1];
        visited = new boolean[C + 1][C + 1][C + 1];

        solve(0, 0, arr[3]);

        for (int i = 0; i < checkAnswer.length; i++) {
            if (checkAnswer[i]) System.out.print(i + " ");
        }
    }
}