import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] moneys = {500, 100, 50, 10, 5, 1};

        int spending = Integer.parseInt(br.readLine());
        spending = 1000 - spending;
        int result = 0;
        for (int i = 0; i < moneys.length; i++) {
            if (moneys[i] > spending) continue;

            result += spending / moneys[i];
            spending %= moneys[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}