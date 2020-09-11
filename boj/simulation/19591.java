import java.util.*;
import java.io.*;

public class Main {

    static int LEFT = 1, RIGHT = 0, SAME = -1;

    static long calculate(String l, String o, String r) {
        long left = Long.parseLong(l);
        long right = Long.parseLong(r);

        if (o.equals("+")) { return left+right; }
        else if (o.equals("-")) { return left-right; }
        else if (o.equals("*")) { return left*right; }
        else { return left/right; }
    }

    static int prior(String oper1, String oper2) {
        // 파라미터1이 2보다 우선될 때 return 1
        // 파라미터2가 1보다 우선될 때 return 0
        // 둘의 우선순위가 같을 때는 -1
        if (oper1.equals("*") || oper1.equals("/")) {
            // 파라미터1이 곱셈 나눗셈인 경우에는 무조건
            if (oper2.equals("*") || oper2.equals("/")) return SAME;
            else { return LEFT; }
        }
        else {
            // 파라미터가 덧셈 뺄셈인 경우
            if (oper2.equals("*") || oper2.equals("/")) return RIGHT;
            else { return SAME; }
        }
    }

    static String go(ArrayList<String> list) {
        if (list.size() == 0) return "0";
        if (list.size() == 1) return list.get(0);

        int frontHead = 0, backHead = list.size()-1;
        while (frontHead < backHead) {
            long front = calculate(list.get(frontHead), list.get(frontHead+1), list.get(frontHead+2));
            long back = calculate(list.get(backHead-2), list.get(backHead-1), list.get(backHead));

            int prior = prior(list.get(frontHead+1), list.get(backHead-1));

            if (prior == LEFT) {
                list.set(frontHead+2, String.valueOf(front));
                frontHead += 2;
            }
            else if (prior == RIGHT) {
                list.set(backHead-2, String.valueOf(back));
            }
            else {
                if (front < back) {
                    list.set(backHead-2, String.valueOf(back));
                    backHead -= 2;
                }
                else {
                    list.set(frontHead+2, String.valueOf(front));
                    frontHead += 2;
                }
            }
        }

        return list.get(frontHead);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();
        StringBuffer buffer = new StringBuffer();

        // 수식의 리스트 초기화
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (i != 0 && (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/' || input.charAt(i) == '*')) {
                list.add(buffer.toString());
                list.add(String.valueOf(input.charAt(i)));
                buffer = new StringBuffer();
            }
            else {
                buffer.append(input.charAt(i));
            }
        }
        list.add(buffer.toString());

        writer.write(go(list));
        writer.flush();
    }
}