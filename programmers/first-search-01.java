// 참고 사이트 : https://lkhlkh23.tistory.com/74 <- 대천재

class Solution {
    public int calc(int index, int sum, int[] numbers, int target) {
        if (index == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }

        return calc(index + 1, sum + numbers[index], numbers, target) + calc(index + 1, sum - numbers[index], numbers, target);
    }

    public int solution(int[] numbers, int target) {
        return calc(0, 0, numbers, target);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1,1,1,1,1};
        int target = 3;
        System.out.println(s.solution(arr, target));
    }
}