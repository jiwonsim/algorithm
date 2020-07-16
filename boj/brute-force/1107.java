
import java.io.*;

public class Main {

    static int goal;
    static boolean[] disables;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input & init
        goal = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        String[] input;
        disables = new boolean[10];

        if (count != 0) {
            input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                disables[Integer.parseInt(input[i])] = true;
            }
        }

        int result = search();
        bw.write(result + "\n");
        bw.flush();
    }

    static int search() {
        int MIN = Math.abs(goal - 100);

        for (int cur = 0; cur <= 1000000; cur++) {
            int count = countOfPressingButton(cur);

            if (count == -1) continue;
            int pressingNumber = Math.abs(goal - cur);
            MIN = Math.min(count + pressingNumber, MIN);
        }

        return MIN;
    }

    static int countOfPressingButton(int num) {
        if (num == 0) {
            if (disables[num]) return -1;
            return 1;
        }

        int count = 0;
        while (num > 0) {
            if (disables[num % 10]) return -1;
            num /= 10;
            count++;
        }

        return count;
    }

}