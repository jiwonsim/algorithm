import java.util.*;
import java.io.*;

public class Main {

    static int adding(String operOfAdd) {
        String[] numbers = operOfAdd.split("\\+");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += Integer.valueOf(numbers[i]);

        return sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bigNumbers = br.readLine().split("-");

        int result = adding(bigNumbers[0]);
        for (int i = 1; i < bigNumbers.length; i++) {
            result -= adding(bigNumbers[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}