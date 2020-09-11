import java.util.*;
import java.io.*;

/*
이전에는 숫자랑 연산을 모두 한 리스트에 넣어서
그걸 다 탐색하느라고(?) 시간초과가 난 것 같다.
이전과 같이 배열을 이용했지만 숫자와 연산을 나눠서 계산했기 때문에 시간초과가 나지 않고 통과했다. 
 */

public class Main {

    static char[] oper;
    static long[] nums;

    static long calculate(long l, char o, long r) {
        if (o == '+') return l+r;
        else if (o == '-') return l-r;
        else if (o == '*') return l*r;
        else return l/r;
    }

    static int prior(char oper) {
        if (oper == '*' || oper == '/') return 1;
        else return 0;
    }

    static Long go(int numsHead, int operHead) {

        int numsFirst = 0, numsLast = numsHead;
        int operFirst = 0, operLast = operHead;

        while (numsFirst < numsLast) { // 숫자가 하나만 남을 때까지
            long frontL = nums[numsFirst], frontR = nums[numsFirst+1];
            char frontO = oper[operFirst];
            long frontRes = calculate(frontL, frontO, frontR);

            long backR = nums[numsLast], backL = nums[numsLast-1];
            char backO = oper[operLast];
            long backRes = calculate(backL, backO, backR);

            boolean f = false, b = false;
            if (prior(frontO) > prior(backO)) f = true;
            else if (prior(frontO) < prior(backO)) b = true;
            else {
                if (frontRes >= backRes) f = true;
                else b = true;
            }

            if (f) {
                numsFirst+=1;
                nums[numsFirst] = frontRes;
                operFirst+=1;
            }
            else {
                numsLast-=1;
                nums[numsLast] = backRes;
                operLast-=1;
            }
        }
        return nums[numsFirst];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();
        StringBuffer buffer = new StringBuffer();

        // 수식을 위한 덱 초기화
        oper = new char[10000000+1];
        nums = new long[10000000+1];
        int numsHead = 0, operHead = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i != 0 && (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/' || input.charAt(i) == '*')) {
                oper[operHead] = input.charAt(i);
                nums[numsHead] = Long.parseLong(buffer.toString());
                numsHead+=1;
                operHead+=1;
                buffer = new StringBuffer();
            }
            else {
                buffer.append(input.charAt(i));
            }
        }
        nums[numsHead] = Long.parseLong(buffer.toString());

        writer.write(go(numsHead, operHead-1) + "");
        writer.flush();
    }
}