import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        HashSet<Integer> hs = new HashSet<>();
        int[] sg = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
//            hs.add(sc.nextInt());
            sg[i] = Integer.parseInt(input[i]);

        Arrays.sort(sg);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(sg[i])) hm.put(sg[i], hm.get(sg[i]) + 1);
            else hm.put(sg[i], 1);
        }

        int M = Integer.parseInt(br.readLine());

        int[] num = new int[M];
        int[] res = new int[M];

        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(input[i]);
            if (hm.containsKey(num[i])) res[i] = hm.get(num[i]);
        }

        for (int i = 0; i < M; i++) {
            System.out.printf("%d ", res[i]);
        }
    }
}