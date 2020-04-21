import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화
        int N = Integer.parseInt(br.readLine());
        int[] series = new int[N];
        int[] count = new int[1000001];
        Stack<Integer> stack = new Stack<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            series[i] = Integer.parseInt(input[i]);
            count[series[i]]++;
        }

        int[] result = new int[N];

        stack.add(0);
        for (int i = 1; i < N; i++) {
            int cur = count[series[i]];

            while (!stack.isEmpty() && count[series[stack.peek()]] < cur) {
                result[stack.pop()] = series[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int ele : result) {
            sb.append(ele + " ");
        }

        System.out.println(sb.toString());

    }
}