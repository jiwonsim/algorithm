import java.io.*;
import java.util.*;

public class Main {

    static int getParent(int[] set, int x) {
        if (set[x] == x) return x;
        set[x] = getParent(set, set[x]);
        return set[x];
    }

    static boolean isConnected(int[] set, int x, int y) {
        x = getParent(set, x);
        y = getParent(set, y);

        if (x == y) return true;
        return false;
    }

    static void unionParent(int[] set, int x, int y) {
        x = getParent(set, x);
        y = getParent(set, y);

        if (x < y) set[y] = x;
        else set[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] set = new int[n + 1]; // init set
        for (int i = 1; i <= n; i++) set[i] = i;

        while (m-- > 0) {
            input = br.readLine().split(" ");
            int op = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);

            if (op == 0) { // connecting
                unionParent(set, x, y);
            }
            else { // check connection
                bw.write(isConnected(set, x, y) ? "YES" + "\n" : "NO" + "\n");
                bw.flush();
            }
            bw.flush();
        }
        bw.close();
    }
}
