import java.io.*;

public class Main {
    static int N;
    static String cmds;
    static String[] numbers;

    static String solve() {
        int front = 0, rear = N - 1, len = N, pointer = front, reverseCnt = 0;
        for (int i = 0; i < cmds.length(); i++) {
            char cmd = cmds.charAt(i);

            if (cmd == 'R') {
                reverseCnt++;
                if (pointer == front) pointer = rear;
                else if (pointer == rear) pointer = front;
            }
            if (cmd == 'D') {
                if (len <= 0 || pointer < 0) {
                    return "error";
                }

                numbers[pointer] = "";
                if (pointer == rear) pointer = --rear;
                else if (pointer == front) pointer = ++front;
                len--;

            }
        }

        StringBuffer sb = new StringBuffer();
        if (reverseCnt % 2 == 0) { // 안 뒤집힘
            for (int i = 0; i < N; i++) {
                if (numbers[i].equals("")) continue;
                sb.append(numbers[i] + ",");
            }
        }
        else {
            for (int i = N - 1; i >= 0; i--) {
                if (numbers[i].equals("")) continue;
                sb.append(numbers[i] + ",");
            }
        }

        String result = sb.toString();
        if (result.length() <= 0) result = "[]";
        else result = result.substring(0, result.length() - 1);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            cmds = br.readLine();
            N = Integer.parseInt(br.readLine());
            numbers = br.readLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",");

            String answer = solve();
            if (answer.equals("error") || answer.equals("[]")) bw.write(answer + "\n");
            else bw.write("[" + answer + "]\n");
            bw.flush();
       }

        bw.close();
    }
}