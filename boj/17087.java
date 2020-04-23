import java.util.*;
import java.io.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 동생들 수
        int M = Integer.parseInt(input[1]); // 수빈이의 위치

        String[] pointString = br.readLine().split(" "); // 동생들의 위치
        int[] points = new int[pointString.length];
        for (int i = 0; i < pointString.length; i++) {
            points[i] = Math.abs(Integer.parseInt(pointString[i]) - M);
        }

        int result = 0;
        if (points.length == 1) result = points[0];
        else {
            result = gcd(points[0], points[1]);
            for (int i = 2; i < points.length; i++) {
                result = gcd(points[i], result);
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}