import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 초과 해결 1. String 객체 대신 int, char 쓰기
// 틀렸습니다 해결 1. left(1) = 10, right(1) = 1000
// 시간 초과 해결 2. 처음에 String을 받아서 방문체크를 LinkedList로 했다.. contains()가 있어서.
//                int로 바꾸면서 boolean visited[]으로 바꾸었다
// 시간 초과 해결 3. 질문게시판에서 보니까 left/right()를 최대한 단순하게 하라고 해서
//                 int를 이용해서 바꾸는 방법으로 수정하였다.

// 문제가 쉬워서 금방 할 줄 알았는데 엄청 돌아돌아서 풀었다.
// 내가 간과했던 걸 나중에도 기억하고 시간초과의 늪에서 벗어나기를!

class Pair {
    int input;
    String command;
    Pair(int input, String command) {
        this.input = input;
        this.command = command;
    }
}

public class Main {
    public static String solve(int input, int answer) {
        Queue<Pair> q = new LinkedList<>();
        boolean visited[] = new boolean[10000];
        Arrays.fill(visited, false);

        q.offer(new Pair(input, ""));
        visited[input] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if(p.input == answer) {
                return p.command;
            }

            int res;

            // D
            res = (p.input * 2) % 10000;
            if (!visited[res]) {
                q.offer(new Pair(res, p.command + "D"));
                visited[res] = true;
            }
            // S
            res = p.input - 1 < 0 ? 9999 : p.input - 1;
            if (!visited[res]) {
                q.offer(new Pair(res, p.command + "S"));
                visited[res] = true;
            }
            // L
            res = (p.input % 1000) * 10 + p.input / 1000;
            if (!visited[res]) {
                q.offer(new Pair(res, p.command + "L"));
                visited[res] = true;
            }
            // R
            res = (p.input % 10) * 1000 + (p.input / 10);
            if (!visited[res]) {
                q.offer(new Pair(res, p.command + "R"));
                visited[res] = true;
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int input, answer;
        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input = Integer.parseInt(st.nextToken());
            answer = Integer.parseInt(st.nextToken());
            System.out.println(solve(input, answer));
        }
    }
}