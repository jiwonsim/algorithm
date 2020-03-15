import java.io.*;
import java.util.*;

public class Main {

    static int getParent(int[] set, int x) {
        if (set[x] == x) return x;
        return set[x] = getParent(set, set[x]);
    }

    static void union(int[] set, int x, int y) {
        x = getParent(set, x);
        y = getParent(set, y);

        if (x < y) set[y] = x;
        else set[x] = y;
    }

    static boolean isSameParent(int[] set, int x, int y) {
        x = getParent(set, x);
        y = getParent(set, y);

        if (x == y) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // count of cities
        int M = Integer.parseInt(br.readLine()); // count of cities to visit

        // initialize set
        int[] set = new int[N + 1];
        for (int i = 0; i < N; i++) set[i] = i;

        // union operation
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                if (input[j].equals("1")) {
                    union(set, i, j);
                }
            }
        }

        // check whether they have same route node
        String[] schedule = br.readLine().split(" ");
        int first = Integer.parseInt(schedule[0]) - 1, second;
        String answer = "YES";
        for (int i = 1; i < schedule.length; i++) {
            second = Integer.parseInt(schedule[i]) - 1;
            if (!isSameParent(set, first, second)) {
                answer = "NO";
                break;
            }
            first = second; // swapping
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
