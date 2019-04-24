import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair {
    int index;
    int value;
    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    static int N;
//    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int pack[];
    static int sum, MIN = Integer.MAX_VALUE;

    public static void solve(int count) {
        if (count == MIN) return;

        for (int i = 0; i < N; i++) {

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pack = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // map : ()
            int input = Integer.parseInt(st.nextToken());
//            map.put(i, inp9ut);
            pack[i] = input;
        }

//        Arrays.sort(pack);
        for (int i = 0; i < N; i++) {
            System.out.print(pack[i] + " ");
        }
        solve(0);
        System.out.println(MIN);
    }
}