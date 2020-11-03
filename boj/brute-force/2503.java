import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] strikes, balls;
    static String[] numbers;

    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        numbers = new String[N];
        strikes = new int[N];
        balls = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");

            numbers[i] = input[0];
            strikes[i] = Integer.parseInt(input[1]);
            balls[i] = Integer.parseInt(input[2]);
        }

        int count = 0;
        for (int curNum = 123; curNum <= 999; curNum++) {
            String cur = String.valueOf(curNum);

            boolean flag = true;
            boolean[] duplicated = new boolean['z'+1];
            for (char c : cur.toCharArray()) {
                if (c == '0') flag = false;
                if (duplicated[c]) flag = false;
                duplicated[c] = true;
            }
            if (!flag) continue;

            for (int i = 0; i < N; i++) {
                String target = numbers[i];
                int[] checks = new int[3]; // 0: none, 1: strike, 2: ball

                for (int j = 0; j < 3; j++) {
                    if (target.charAt(j) == cur.charAt(j)) {
                        checks[j] = 1; // strike
                    }

                    for (int k = 0; k < 3; k++) {
                        if (target.charAt(k) == cur.charAt(j) && checks[j] == 0) {
                            checks[j] = 2; // ball
                        }
                    }
                }

                int strike = 0, ball = 0;
                for (int check : checks) {
                    if (check == 1) strike+=1;
                    if (check == 2) ball+=1;
                }

                if (strikes[i] != strike || balls[i] != ball) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        writer.write(count+"\n");
        writer.flush();
        writer.close();
    }
}
