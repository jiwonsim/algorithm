import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static long result = 0;
    static char[][] inputs;

    static boolean[] checkedNum;
    static ArrayList<Integer> valueList = new ArrayList<>();
    static int[] value;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.valueOf(br.readLine());
        inputs = new char[N][];
        checkedNum = new boolean[10];


        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine().toCharArray();

            for (char input : inputs[i]) {
                if (valueList.contains(input - 'A')) continue;
                valueList.add(input - 'A');
            }
        }

        value = new int[valueList.size()];

        find(0);

        System.out.println(result);

    }
    static void find(int depth) {
        if (depth == valueList.size()) {
            result = Math.max(result, calculate());
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (checkedNum[i]) continue;

            checkedNum[i] = true;
            value[depth] = i;
            find(depth + 1);
            value[depth] = 0;
            checkedNum[i] = false;
        }
    }

    static long calculate() {

        long sum = 0;

        for (char[] input : inputs) {
            long number = 0;
            for (char ele : input) {
                number *= 10;
                number += value[valueList.indexOf(ele - 'A')];
            }
            sum += number;
        }


        return sum;
    }
}