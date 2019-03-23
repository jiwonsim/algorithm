import java.util.Scanner;

public class Main {
    static boolean isPrime[] = new boolean[1000001];

    //입력 받을 때마다 prime인지 검사하면 시간초과가 난다.
    //처음부터 prime 검사 결과를 배열에 저장하고 입력 받을 때는 확인만 하면 정답.
    public static void initPrime() {
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {
            for (int j = i*2; j < isPrime.length; j+=i) {
                if (!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
    }

    public static void printResult(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (isPrime[i] && isPrime[num - i]) {
                System.out.println(num + " = " + Math.min(i, num - i) + " + " + Math.max(i, num - i));
                return;
            }
        }
        System.out.println("Goldbach's conjecture is wrong.");
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initPrime();
        while (true) {
            int input = sc.nextInt();
            if (input == 0) return;
            printResult(input);
        }
    }
}