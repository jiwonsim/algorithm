import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            que.add(Integer.valueOf(input[i]));
        }

        int sum = 0, len = input.length;
        while (!que.isEmpty()) {
            sum += que.poll() * len--;
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}