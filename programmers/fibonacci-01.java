

// Bottom Up
class BottomUp {
    public int fib(int k) {
        int result = 0;
        if (k == 1 || k == 2) return k;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= k; i++) {
            result = first + second;
            first = second % 1234567;
            second = result % 1234567;
        }
        return result % 1234567;
    }

    public int solution(int n) {
        int answer = 0;
        answer = fib(n);
        return answer;
    }
}


class Memorization {
    public int fib(int k, int[] mem) {
        if (k <= 1) return k;

        if (mem[k] != 0) return mem[k];

        mem[k] = fib(k - 1, mem) + fib(k - 2, mem);
        return mem[k];
    }
    public int solution(int n) {
        int answer = 0;
        int[] mem = new int[100001];
        answer = fib(n, mem);
        return answer;
    }
}


class Rescursion {
    public int fib(int k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        return fib(k - 1) + fib(k - 2);
    }
    public int solution(int n) {
        int answer = 0;
        answer = fib(n);
        return answer;
    }
}