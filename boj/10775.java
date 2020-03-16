import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        parent[x] = y;
    }

    public static void main(String[] args) throws IOException {

        int G = Integer.parseInt(br.readLine()); // number of Gate
        int P = Integer.parseInt(br.readLine()); // number of Plane

        int count = 0;

        int[] parent = new int[100001];
        for (int i = 1; i <= G; i++) parent[i] = i;

        while (P-- > 0){
            int input = Integer.parseInt(br.readLine());
            int par = find(parent, input);

            if (par == 0) break;
            else { // it can fill more !
                union(parent, par, par - 1);
                count++;
            }
        }

        System.out.printf("%d", count);
    }
}
