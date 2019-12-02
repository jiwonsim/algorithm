import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0, end = 0;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] op = br.readLine().split(" ");

            if (op.length == 1) {
                if (op[0].equals("pop_front")) {
                    if (deque.size() == 0) bw.write("-1\n");
                    else bw.write(deque.pollFirst() + "\n");
                    bw.flush();
                }
                if (op[0].equals("pop_back")) {
                    if (deque.size() == 0) bw.write("-1\n");
                    else bw.write(deque.pollLast() + "\n");
                    bw.flush();
                }
                if (op[0].equals("size")) {
                    bw.write(deque.size() + "\n");
                    bw.flush();
                }
                if (op[0].equals("empty")) {
                    int answer = deque.isEmpty() ? 1 : 0;
                    bw.write(answer + "\n");
                    bw.flush();
                }
                if (op[0].equals("front")) {
                    if (deque.size() == 0) bw.write("-1\n");
                    else bw.write(deque.peekFirst() + "\n");
                    bw.flush();
                }
                if (op[0].equals("back")) {
                    if (deque.size() == 0) bw.write("-1\n");
                    else bw.write(deque.peekLast() + "\n");
                    bw.flush();
                }
            }
            else {
                if (op[0].equals("push_front")) {
                    deque.addFirst(Integer.parseInt(op[1]));
                }
                if (op[0].equals("push_back")) {
                    deque.addLast(Integer.parseInt(op[1]));
                }
            }
        }

        bw.close();
    }
}