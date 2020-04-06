import java.util.*;

class Pair {
    int val, day;

    Pair(int val, int day) {
        this.val = val;
        this.day = day;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};

        Stack<Pair> stack = new Stack<>();
        answer = new int[prices.length];
        answer[prices.length - 1] = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.add(new Pair(prices[i], 1));
                answer[i] = 1;
            }
            else {
                int day = 1;
                while (!stack.isEmpty() && stack.peek().val >= prices[i]) {
                    day += stack.pop().day;
                }

                stack.add(new Pair(prices[i], day));
                answer[i] = day;
            }

        }
        return answer;
    }
}