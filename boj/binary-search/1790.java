import java.io.*;
import java.util.*;

public class Main {

    static long findLength(int number) {
        long ans = 0;

        for (int start=1, len=1; start<=number; start*=10, len++) {
            int end = start*10-1;
            if (end>number) { end = number; }
            ans += (long)(end-start+1)*len;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        long M = Long.parseLong(input[1]);

        if (findLength(N) < M) {
            bw.write("-1");
            bw.flush();
            return;
        }

        int start = 1;
        int end = N;

        int ans = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            long midLen = findLength(mid);

            if (midLen >= M) {
                end = mid-1;
                ans = mid;
            }
            else {
                start = mid+1;
            }
        }
        String str = String.valueOf(ans);
        long l = findLength(ans);
        int index = (int)(str.length()-(l-M+1));

        bw.write(str.charAt(index));
        bw.flush();
    }
}
