import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int length = input.length();

        StringBuilder result = new StringBuilder();
        String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};
        for (int i = 0; i < length; i++) {
            int cur = input.charAt(i) - '0';
            if (i == 0) {
                result.append(Integer.parseInt(octal[cur]));
            }
            else result.append(octal[cur]);
        }

        bw.write(result.toString());
        bw.flush();
    }
}