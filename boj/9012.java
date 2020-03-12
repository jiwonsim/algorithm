import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        String ps;
        while (N-- > 0) {
            ps = br.readLine();

            int left = 0, right = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < ps.length(); i++) {
                stack.add(ps.charAt(i));
            }

            if (stack.isEmpty()) continue;

            char cur = stack.pop(); // last element

            if (cur == '(') { // NO
                bw.write("NO\n");
                continue;
            }
            if (cur == ')') right++;

            boolean isValid = true;
            while (!stack.isEmpty()) {
                char comp = stack.pop();

                if (comp == '(' && right > 0) {
                    right -= 1;
                }
                else if (comp == '(' && right <= 0) {
                    bw.write("NO\n");
                    isValid = false;
                    break;
                }
                else if (comp == ')') right++;
            }

            if (isValid) {
                if (left == 0 && right == 0) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }
}