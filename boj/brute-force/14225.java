// https://www.acmicpc.net/problem/14225

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] visited, checked;

    static void find(int count, int sum) {
        if (count == N) {
            checked[sum] = true;
            return;
        }

        find(count + 1, sum + numbers[count]);
        find(count + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        visited = new boolean[N];
        checked = new boolean[100000 * 20 + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            checked[numbers[i]] = true;
        }

        find(0, 0);

        for (int i = 1; i < checked.length; i++) {
            if (!checked[i]) {
                System.out.printf("%d", i);
                return;
            }
        }

    }
}