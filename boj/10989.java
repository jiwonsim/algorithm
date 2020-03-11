import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {
            count[Integer.valueOf(br.readLine())]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i + "\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}