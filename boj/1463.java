import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cache[];

//     1번 재귀
//    public static int dp(int N, int[] cache) {
//        if (N == 1) return 0;
//        if (cache[N] > 0) {
//            return cache[N];
//        }
//
//        cache[N] = dp(N-1, cache) + 1;
//
//        if (N%3 == 0) {
//            cache[N] = Math.min(dp(N/3, cache) + 1, cache[N]);
//        }
//        if (N%2 == 0) {
//            cache[N] = Math.min(dp(N/2, cache) + 1, cache[N]);
//        }
//        return cache[N];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N + 1];
        cache[0] = 0;
        cache[1] = 0;
//        2번 그냥 포문
        for (int i = 2; i < N + 1; i++) {
            cache[i] = cache[i-1] + 1;

            if (i % 2 == 0) {
                if (cache[i/2] + 1 < cache[i]) //최솟값을 구해야되니까!
                    cache[i] = cache[i/2] + 1;
            }
            if (i % 3 == 0) {
                if (cache[i/3] + 1 < cache[i])
                    cache[i] = cache[i/3] + 1;
            }
        }

        System.out.println(cache[N]);
    }
}