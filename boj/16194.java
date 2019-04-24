import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
//    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int pack[], ans[];
    static int sum, MIN = Integer.MAX_VALUE;

    public static void solve(int count) {
        if (count == MIN) return;

        for (int i = 1; i <= N; i++) {
            ans[i] = pack[i];
            for (int  j = 1; j <= i; j++) {
//                System.out.println("ans : " + ans[j]);
//                System.out.println("pack : " + pack[j]);
//                System.out.println("==============");

                ans[i] = ans[i] < ans[i - j] + pack[j] ? ans[i] : ans[i - j] + pack[j];
            }

//            System.out.println("ans : " + ans[N]);
//            System.out.println("pack : " + pack[N]);
//            System.out.println("==============");

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pack = new int[N + 1];
        ans = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // map : ()
            int input = Integer.parseInt(st.nextToken());
//            map.put(i, input);
            pack[i] = input;
        }

        solve(0);
        System.out.println(ans[N]);
    }
}