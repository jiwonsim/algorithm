import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] result, waters;

    static int solve() {

        if (n >= 1) result[0] = waters[0];
        if (n >= 2) result[1] = waters[0] + waters[1];
        if (n >= 3) result[2] = Math.max(result[1], Math.max(result[0] + waters[2], waters[1] + waters[2]));

        for (int i = 3; i < n; i++) {
            result[i] = Math.max(result[i - 1],
                    Math.max(result[i - 2] + waters[i], result[i - 3] + waters[i - 1] + waters[i]));
        }

        return result[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        waters = new int[n];
        result = new int[n];
        for (int i = 0; i < n; i++) {
            waters[i] = Integer.parseInt(br.readLine());
        }

        int answer = solve();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}