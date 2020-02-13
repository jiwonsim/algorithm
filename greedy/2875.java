import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        int K = Integer.valueOf(input[2]);

        int answer = 0;
        while (true) {
            if (N < 2 || M < 1) break;
            if (N + M - 3 < K) break;

            N -= 2;
            M -= 1;

            answer++;
        }

//        // 팀 만들기
//        int answer = 0, remainder = 0;
//        if (N / 2 >= M) {
//            answer = M;
//            remainder = N - M * 2;
//        }
//        else {
//            answer = N / 2;
//            remainder = N % 2 + M - N / 2;
//        }
//
//
//        // 인원 빼기
//        if (remainder < K) {
//            K -= remainder;
//            if (K / 3 > 0) {
//                answer = (int)((double)answer - (double)K / 3);
//            }
//            else answer--;
//        }
//        if (answer < 0) answer = 0;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}