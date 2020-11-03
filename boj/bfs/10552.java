import java.io.*;
import java.util.*;

public class Main {

    static int N, M, P, answer = 0;
    static int[] list;
    static boolean[] visited = new boolean[M+1];

    static boolean go(int channel) {
        if (visited[channel]) return false;

        boolean ret = true;
        visited[channel] = true;
        if (list[channel] != 0) {
            answer+=1;
            ret = go(list[channel]);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        visited = new boolean[M+1];
        list = new int[M+1];

        for (int i = 0; i < N; i++) {
            String[] channels = reader.readLine().split(" ");
            int favourite = Integer.parseInt(channels[0]);
            int hated = Integer.parseInt(channels[1]);

            if (list[hated] == 0) list[hated] = favourite;
        }

        writer.write(go(P) ? answer + "\n" : "-1\n");
        writer.flush();
        writer.close();
    }
}
