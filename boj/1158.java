import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < N; i++) que.add(i + 1);
        StringBuffer sb = new StringBuffer();

        sb.append("<");
        while (!que.isEmpty()) {
            for (int i = 1; i < K; i++) {
                int delEle = que.poll();
                que.add(delEle);
            }

            if (que.size() == 1)
                sb.append(que.poll());
            else
                sb.append(que.poll() + ", ");
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

        bw.close();
    }
}