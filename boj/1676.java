import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        if (N == 0) result = 0;
        else result = N / 5;
        result += N / 25;
        result += N / 125;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}