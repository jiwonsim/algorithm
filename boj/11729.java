import java.io.*;

public class Main {
    static StringBuffer result = new StringBuffer();

    static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            result.append(from + " " + to + "\n");
            return;
        }

        hanoi(n - 1, from, aux, to);
        result.append(from + " " + to + "\n");
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        for (int i = 0; i < n - 1; i++) {
            sum = sum * 2 + 1;
        }

        result.append(sum + "\n");

        hanoi(n, 1, 3, 2);
        System.out.printf("%s", result);
    }
}