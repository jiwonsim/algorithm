import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Serial implements Comparable<Serial> {

        String content;
        int length, sum;

        Serial (String content) {
            this.content = content;
            this.length = content.length();

            for (int i = 0; i < this.length; i++) {
                if ('1' <= content.charAt(i) && content.charAt(i) <= '9')
                    this.sum += content.charAt(i) - '0';
            }
        }

        @Override
        public int compareTo(Serial target) {
            if (this.length == target.length) {
                if (this.sum == target.sum) {
                    return this.content.compareTo(target.content);
                }
                else return this.sum - target.sum;
            }
            else return this.length - target.length;
        }
    }



    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(br.readLine());
        Serial[] serials = new Serial[N];

        for (int i = 0; i < N; i++) {
            serials[i] = new Serial(br.readLine());
        }

        Arrays.sort(serials);

        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            answer.append(serials[i].content + "\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}