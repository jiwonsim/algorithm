import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int len = N.length();
        int num = Integer.parseInt(N);

        int ten = 1;
        long result = 0;
        for (int i = 1; i <= len; i++) {
            if (len == i) {
                result += (num - ten + 1) * i;
                break;
            }
            result += 9 * ten * i;
            ten *= 10;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}