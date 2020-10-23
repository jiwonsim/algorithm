import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static int GOOD = 0, BAD = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int today = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        double[][] prob = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                prob[i][j] = Double.parseDouble(input[i*2+j]);
            }
        }

        double[][] ans = new double[100+1][2];

        ans[0][GOOD] = prob[today][GOOD];
        ans[0][BAD] = prob[today][BAD];

        for (int i = 1; i <= N; i++) {
            ans[i][GOOD] = ans[i-1][GOOD] * prob[GOOD][GOOD] + ans[i-1][BAD] * prob[BAD][GOOD];
            ans[i][BAD] = ans[i-1][BAD] * prob[BAD][BAD] + ans[i-1][GOOD] * prob[GOOD][BAD];
        }

        writer.write(Math.round(ans[N-1][GOOD] * 1000) + "\n" + Math.round(ans[N-1][BAD] * 1000));
        writer.flush();
        writer.close();
    }
}

