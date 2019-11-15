import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int[] A;
    static int[] result;

    static int[] solve() {

        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();

            stack.add(A[i]);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        result = new int[N];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(in[i]);
        }

        int[] answers = solve();
        for (int answer : answers) bw.write(answer + " ");
        bw.flush();
    }
}