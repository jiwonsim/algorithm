import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> str = new ArrayList<String>();
        int count[] = new int[N];

        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (!str.contains(input)) {
                str.add(input);
            }
            count[str.indexOf(input)]++;
            if (count[str.indexOf(input)] > MAX) {
                MAX = count[str.indexOf(input)];
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            if (count[i] == MAX)
                res.add(str.get(i));
        }

        Collections.sort(res);
        System.out.println(res.get(0));
    }
}