import java.util.*;
import java.io.*;

public class Main {
    static int ZERO = 0, ONE = 1, MINUSONE = -1;
    static int N, zero, one, minusOne;
    static int[][] paper;

    static boolean isSamePaper(int y, int x, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != val) return false;
            }
        }

        return true;
    }

    static void countPaper(int val) {
        if (val == ZERO) zero++;
        else if (val == ONE) one++;
        else if (val == MINUSONE) minusOne++;
    }

    static void solve(int y, int x, int size) {
        for (int i = 0; i < 9; i++) {
            int curY = y + (i / 3) * size;
            int curX = x + (i % 3) * size;

            if (isSamePaper(curY, curX, size, paper[curY][curX])) {
                countPaper(paper[curY][curX]);
            }
            else {
                solve(curY, curX, size / 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(in[j]);
            }
        }

        if (isSamePaper(0, 0, N, paper[0][0])) {
            countPaper(paper[0][0]);
        }
        else {
            solve(0, 0, N / 3);
        }

        bw.write(minusOne + "\n" + zero + "\n" + one);
        bw.flush();
        bw.close();

    }
}