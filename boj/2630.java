import java.io.*;

public class Main {
    static int BLUE = 1, WHITE = 0;
    static int N, whiteCnt, blueCnt;
    static int[][] paper;
    static boolean[][] visited;

    static boolean isSameColor(int y, int x, int size) {
        int color = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != paper[i][j]) return false;
            }
        }

        return true;
    }

    static void search(int y, int x, int size) {
        if (size == 1) {
            if (paper[y][x] == BLUE) blueCnt++;
            else whiteCnt++;
            return;
        }

        if (isSameColor(y, x, size)) {
            if (paper[y][x] == BLUE) blueCnt++;
            else whiteCnt++;
            return;
        }

        int nextSize = size / 2;
        search(y, x, nextSize);
        search(y + nextSize, x, nextSize);
        search(y, x + nextSize, nextSize);
        search(y + nextSize, x + nextSize, nextSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (in[j].equals("1")) paper[i][j] = 1;
                else paper[i][j] = 0;
            }
        }

        search(0, 0, N);

        bw.write(whiteCnt + "\n" + blueCnt);
        bw.flush();

        bw.close();
    }
}