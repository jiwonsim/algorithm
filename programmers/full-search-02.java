import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    List<Integer> list = new ArrayList<>();

    public void search(String number, String numbers, boolean visited[]) {

        if (isPrime(Integer.parseInt(number))) {
            if (!list.contains(Integer.parseInt(number))) {
                list.add(Integer.parseInt(number));
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            search(number + numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        boolean visited[] = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            visited[i] = true;
            search("" + numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }

        answer = list.size();

        return answer;
    }
}