// https://www.acmicpc.net/problem/16198

import java.io.*;
import java.util.*;

public class Main {

    static int N, result = 0;
    static int[] numbers;
    static boolean[] visited;

    static int getLeft(int left) {
        while (left >= 0) {
            if (!visited[left]) return numbers[left];
            left -= 1;
        }
        return numbers[left + 1];
    }

    static int getRight(int right) {
        while (right < numbers.length) {
            if (!visited[right]) return numbers[right];
            right += 1;
        }
        return numbers[right - 1];
    }

    static void search(int sum, int deletedCnt) {
        if (deletedCnt == N - 2) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 1; i < numbers.length - 1; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int left = getLeft(i), right = getRight(i);
            search(sum + left * right, deletedCnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        visited = new boolean[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        search(0, 0);
        System.out.println(result);
    }
}