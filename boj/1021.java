import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numInput = br.readLine().split(" ");
        int N = Integer.parseInt(numInput[0]);
        int M = Integer.parseInt(numInput[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        int result = 0;
        String[] opTemp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int op = Integer.parseInt(opTemp[i]);
            int leftCnt = 0, rightCnt = 0;

            Deque<Integer> leftDeque = ((ArrayDeque<Integer>) deque).clone();
            Deque<Integer> rightDeque = ((ArrayDeque<Integer>) deque).clone();

            int compEle = op, moveEle;
            while (compEle != leftDeque.peekFirst()) {
                moveEle = leftDeque.pollFirst();
                leftDeque.addLast(moveEle);
                leftCnt++;
            }
            leftDeque.pollFirst();

            while (compEle != rightDeque.peekFirst()) {
                moveEle = rightDeque.pollLast();
                rightDeque.addFirst(moveEle);
                rightCnt++;
            }
            rightDeque.pollFirst();

            if (leftCnt > rightCnt) {
                deque = rightDeque;
                result += rightCnt;
            }
            else {
                deque = leftDeque;
                result += leftCnt;
            }
        }

        bw.write(result + "\n");
        bw.flush();

        bw.close();
    }
}