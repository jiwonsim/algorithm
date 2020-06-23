import javax.jws.Oneway;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k;
    static StringBuffer max = new StringBuffer("-1"), min = new StringBuffer("10000000000");
    static int[] result;
    static String[] oper;
    static boolean[] visited ;
    static final int RANGE = 10;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        oper = br.readLine().split(" ");

        result = new int[oper.length + 1];
        visited = new boolean[RANGE];

        for (int i = 0; i < RANGE; i++) {
            visited[i] = true;
            result[0] = i;
            search(i, 1, 0);
            visited[i] = false;
        }

        bw.write(max.toString() + "\n" + min.toString());
        bw.flush();
    }

    static void search(int number, int index, int operIdx) {
        if (operIdx == oper.length) {
            conversion();
        }
        else {
            for (int i = 0; i < RANGE; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                if (oper[operIdx].equals("<")) {
                    if (number < i) {
                        result[index] = i;
                        search(i, index + 1, operIdx + 1);
                    }
                }
                if (oper[operIdx].equals(">")) {
                    if (number > i) {
                        result[index] = i;
                        search(i, index + 1, operIdx + 1);
                    }
                }

                visited[i] = false;
            }
        }
    }

    static void conversion() {
        StringBuffer sum = new StringBuffer();
        for (int ele : result) {
            sum.append(ele);
        }

        if (Long.parseLong(max.toString()) < Long.parseLong(sum.toString()))
            max = sum;
        if (Long.parseLong(min.toString()) > Long.parseLong(sum.toString()))
            min = sum;
    }

}