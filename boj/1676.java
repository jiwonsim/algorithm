import java.io.*;

public class Main{

    static int solve(int N) {

        int answer = 0;
        while (N > 0) {
            answer += N / 5;
            N /= 5;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = solve(N);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }
}