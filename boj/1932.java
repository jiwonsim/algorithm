import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] triangle = new int[150001];
        int n = Integer.parseInt(br.readLine());
        int root = Integer.parseInt(br.readLine());

        triangle[0] = root;
        int start = 0, end = 1, index = 0;
        for (int i = 1; i < n; i++) {
            start += i;
            end += i + 1;


            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                triangle[++index] = Integer.parseInt(input[j]);
                if (index == start) {
                    triangle[index] += triangle[index - i];
                }
                else if (index == end - 1) {
                    triangle[index] += triangle[index - i - 1];
                }
                else {
                    int biggerParent = Math.max(triangle[index - i], triangle[index - i - 1]);
                    triangle[index] += biggerParent;
                }
            }
        }

        int lastLineIdx = (n * (n + 1)) / 2, MAX = -1;
        for (int i = 0; i < n; i++) {
            MAX = Math.max(triangle[lastLineIdx--], MAX);
        }

        System.out.printf("%d", MAX);
    }
}