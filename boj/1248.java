import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] oper;
    static int[] result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new int[N];

        int operIdx = 0;
        oper = new int[N][N];
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i > j) continue;

                if (input[operIdx] == '-') {
                    oper[i][j] = -1;
                }
                if (input[operIdx] == '+') {
                    oper[i][j] = 1;
                }
                if (input[operIdx] == '0') {
                    oper[i][j] = 0;
                }

                operIdx++;
            }
        }

        search(0);
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }

    static boolean search(int index) {
        if (index == N) {
            return true;
        }

        if (oper[index][index] == 0) {
            result[index] = 0;
            return isInRange(index) && search(index + 1);
        }

        for (int i = 1; i <= 10; i++) {
            result[index] = oper[index][index] * i;
            if (isInRange(index) && search(index + 1)) return true;
        }

        return false;
    }

    static boolean isInRange(int index) {

        for (int i = 0; i <= index; i++) {
            int sum = 0;
            for (int j = i; j <= index; j++) {
                sum += result[j];
            }
            if (oper[i][index] > 0 && sum <= 0) return false;
            if (oper[i][index] < 0 && sum >= 0) return false;
            if (oper[i][index] == 0 && sum != 0) return false;
        }

        return true;
    }

}
