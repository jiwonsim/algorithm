import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, S;
    static int arr[], check[], count;
    static boolean visited[];

    public static void solve(int start, int sum) {


//        System.out.println(start);
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
//            System.out.println("sum : " + (sum + arr[i]));
            solve(i + 1, sum + arr[i]);
            visited[i] = false;
        }

        if (start > 0 && sum == S) {
//            System.out.println("result : " + sum);
//            print();
            count++;
        }
    }

    public static void print() {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N];
        check = new int[N];
        visited = new boolean[N];

        String arr_input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arr_input[i]);
        }

        solve(0, 0);
        System.out.println(count);
    }
}