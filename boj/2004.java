import java.io.*;
import java.util.*;

public class Main {
    static int divideByFive(int num) {
        if (num / 5 < 1) return 0;
        return divideByFive(num / 5) + num / 5;
    }

    static int divideByTwo(int num) {
        if (num / 2 < 1) return 0;
        return divideByTwo(num / 2) + num / 2;
    }

    static int compbination(int a, int b) {
        int twoCnt = divideByTwo(a) - (divideByTwo(a - b) + divideByTwo(b));
        int fiveCnt = divideByFive(a) - (divideByFive(a - b) + divideByFive(b));

        return Math.min(twoCnt, fiveCnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int result = compbination(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        bw.write(result + "\n");
        bw.flush();
    }
}