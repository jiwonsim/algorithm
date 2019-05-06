import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean visited[];
    static char arr[];
    static int L, C, res[];
    public static void solve(int start, int depth, int cons, int vow) {
        for (int i = start; i < C; i++) {
            res[i] = 1;

            solve(i + 1, depth + 1, cons + (check(arr[i]) ? 0 : 1), vow + (check(arr[i]) ? 1 : 0));
            res[i] = 0;
        }

        if (depth == L && cons >= 2 && vow >= 1) {
            print();
        }
    }

    public static void print() {
        for (int i = 0; i < C; i++) {
            if (res[i] == 1)
                System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new char[C];
        res = new int[C];
        visited = new boolean[L];
        String letters[] = br.readLine().split(" ");
        for (int i = 0; i < letters.length; i++) {
            arr[i] = letters[i].charAt(0);
        }

//        for (int i = 0; i < C; i++) {
//            System.out.println(arr[i] + " ");
//        }

        Arrays.sort(arr);
        solve(0, 0,0,0 );
    }
}