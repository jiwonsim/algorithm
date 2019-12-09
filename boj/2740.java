import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, K;
    static int[][] A, B, result;

    static void initA() throws IOException {
        String[] ain = br.readLine().split(" ");
        N = Integer.parseInt(ain[0]);
        M = Integer.parseInt(ain[1]);

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] aEle = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(aEle[j]);
            }
        }
    }

    static void initB() throws IOException {
        String[] bin = br.readLine().split(" ");
        K = Integer.parseInt(bin[1]);

        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            String[] bEle = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(bEle[j]);
            }
        }
    }

    static void initResult() {
        result = new int[N][K];
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                for (int m = 0; m < M; m++) {
                    result[n][k] += A[n][m] * B[m][k];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        initA();
        initB();

        initResult();

        // print Result
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}