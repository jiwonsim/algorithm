import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int SIZE = 3;
//    static String input = "";
    static int input;
    static int to_x[] = {0, 0, 1, -1};
    static int to_y[] = {1, -1, 0, 0};

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        q.offer(input);
        map.put(input, 0);

        while (!q.isEmpty()) {
            int now_int = q.poll();
            String now_str = String.valueOf(now_int);
            int nine_idx = now_str.indexOf('9');
            int x = nine_idx / 3;
            int y = nine_idx % 3;

            for (int i = 0; i < 4; i++) {
                int go_x = to_x[i] + x;
                int go_y = to_y[i] + y;

                if (go_x < 0 || go_x >= SIZE || go_y < 0 || go_y >= SIZE) continue;

                StringBuilder next = new StringBuilder(now_str);
                char temp = next.charAt(x * 3 + y);
                next.setCharAt(x * 3 + y, (char)next.charAt(go_x * 3 + go_y));
                next.setCharAt(go_x * 3 + go_y, temp);

                int next_num = Integer.parseInt(next.toString());
                if (!map.containsKey(next_num)) {
                    map.put(next_num, map.get(now_int) + 1);
                    q.offer(next_num);
                }
            }
        }

//        System.out.println("?!");

        if (map.containsKey(123456789)) {
            System.out.println(map.get(123456789));
        }
        else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) temp = 9;
                input = input * 10 + temp;
            }
        }

//        System.out.println(input);
        solve();
    }
}