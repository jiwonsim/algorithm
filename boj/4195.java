import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static HashMap<String, Integer> idMap;

    static int getParent(int[] set, int x) {
        if (set[x] == x) return x;
        return set[x] = getParent(set, set[x]);
    }

    static int union(int[] set, int[] count, int x, int y) throws IOException {
        x = getParent(set, x);
        y = getParent(set, y);

        if (x < y) {
            set[y] = x;
            count[x] += count[y];
            return count[x];
        }
        else if (x == y) {
            return count[x];
        }
        else {
            set[x] = y;
            count[y] += count[x];
            return count[y];
        }
    }

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int f = Integer.parseInt(br.readLine());

            // initialize
            idMap = new HashMap<>();
            int index = 0;
            int[] parent = new int[100001];
            int[] count = new int[100001];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                count[i] = 1;
            }

            // input
            while (f-- > 0) {
                String[] friend = br.readLine().split(" ");

                if (!idMap.containsKey(friend[0])) {
                    idMap.put(friend[0], index++);
                }
                if (!idMap.containsKey(friend[1])) {
                    idMap.put(friend[1], index++);
                }

                int firstIndex = idMap.get(friend[0]);
                int secondIndex = idMap.get(friend[1]);

                int answer = union(parent, count, firstIndex, secondIndex);
                bw.write(answer + "\n");
                bw.flush();
            }
        }
        bw.close();
    }
}
