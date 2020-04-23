import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void makeBinary(int num) {
        if (num == 0) return;

        if (num % 2 == 0) { // 짝수
            makeBinary(num / -2);
            sb.append(0);
        }
        else { // 홀수
            if (num > 0) { // 양수
                makeBinary(num / -2);
            }
            else { // 음수
                makeBinary((num - 1) / -2) ;
            }
            sb.append(1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        if (input == 0) System.out.println(0);
        else {
            makeBinary(input);
            System.out.println(sb.toString());
        }
    }
}