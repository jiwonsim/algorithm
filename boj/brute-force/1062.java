import java.util.*;
import java.io.*;


public class Main {

    static int N, K, result = 0;
    static int[] words;
    static boolean[] learned;

    static int check(int mask) {
        int count = 0;

        for (int word : words) {
            if ((word & ((1<<26)-1-mask)) == 0) {
                count += 1;
            }
        }
        return count;
    }

    static int go(int index, int mask, int depth) {
        if (depth < 0) { return 0; }
        if (index == 26) {
            return check(mask);
        }

        int answer = go(index+1, mask|(1<<index), depth-1);


        if (index != 'a'-'a' && index != 'n'-'a' && index != 't'-'a' && index != 'i'-'a' && index != 'c'-'a') {
            answer = Math.max(answer, go(index+1, mask, depth));
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");

        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);

        words = new int[N];
        learned = new boolean[26];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                words[i] |= (1 << (c-'a'));
            }
        }

        bw.write(go(0, 0, K) + "\n");
        bw.flush();
    }
}