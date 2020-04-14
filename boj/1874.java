import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int k = 1;
        boolean flag = true;
        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());


            while (k <= input) {
                stack.add(k++);
                sb.append("+\n");
            }

            if (stack.isEmpty() && k > input) {
                flag = false;
                break;
            }

            while (!stack.isEmpty() && stack.peek() >= input) {
                stack.pop();
                sb.append("-\n");
            }
        }

        if (!flag) sb = new StringBuilder("NO\n");
        bw.write(sb.toString());
        bw.close();
    }
}