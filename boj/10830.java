import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long B;
    static int MOD = 1000;

    static long[][] power(long[][] A, long[][] B) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (A[i][k] * B[k][j]) % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    static long[][] initMap() {
        long[][] map = new long[N][N];

        for (int i = 0; i < N; i++) {
            map[i][i] = 1;
        }

        return map;
    }

    static long[][] calc(long[][] map) {
        String binaryB = Long.toBinaryString(B);

        long[][] result = initMap();

        for (int i = 0; i < binaryB.length(); i++) {
            result = power(result, result);
            if (binaryB.charAt(i) == '1') {
                result = power(result, map);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        B = Long.parseLong(in[1]);

        long[][] map = new long[N][N];

        for (int i = 0; i < N; i++) {
            String[] ele = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(ele[j]);
            }
        }

        long[][] answer = calc(map);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}