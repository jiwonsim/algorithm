import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer result = new StringBuffer();

    static boolean checkMap(int y, int x, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != val) return false;
            }
        }

        return true;
    }

    static void search(int y, int x, int size) {
        if (size <= 0) return;

        if (!checkMap(y, x, size / 2, map[y][x])) {
            result.append("(");
            search(y, x, size / 2);
        }
        else result.append("(" + map[y][x]);

        if (!checkMap(y, x + size / 2, size / 2, map[y][x + size / 2])) {
            search(y, x + size / 2, size / 2);
        }
        else result.append(map[y][x + size / 2]);

        if (!checkMap(y + size / 2, x, size / 2, map[y + size / 2][x])) {
            search(y + size / 2, x, size / 2);
        }
        else result.append(map[y + size / 2][x]);


        if (!checkMap(y + size / 2, x + size / 2, size / 2, map[y + size / 2][x + size / 2])) {
            search(y + size / 2, x + size / 2, size / 2);
        }
        else result.append(map[y + size / 2][x + size / 2]);

        result.append(")");
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < N; j++) {
                if (in.charAt(j) == '1') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        if (checkMap(0, 0, N, map[0][0])) {
            bw.write(map[0][0] + "\n");
        }
        else {
            search(0, 0, N);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}