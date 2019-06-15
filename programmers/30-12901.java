class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += months[i];
        }

        int startDay = 6;

        int sum2 = (sum + startDay + b - 2);
        sum = sum2 % 7;

        answer = days[sum];

        return answer;
    }
}
