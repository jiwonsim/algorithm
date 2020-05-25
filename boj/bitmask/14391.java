import java.util.*;
        import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        int result = 0;

        for (int bit = 0; bit < 1 << (n * m); bit++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int cur = 0;

                for (int j = 0; j < m; j++) {
                    int k = i * m + j;

                    if ((bit & (1 << k)) == 0) { // 가로
                        cur = cur * 10 + map[i][j];
                    }
                    else { // 세로
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int j = 0; j < m; j++) {
                int cur = 0;

                for (int i = 0; i < n; i++) {
                    int k = i * m + j;

                    if ((bit & (1 << k)) != 0) {
                        cur = cur * 10 + map[i][j];
                    }
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            result = Math.max(result, sum);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}