class Solution {
    public String solution(int n) {
        String answer = "";
        String[] wm = {"수", "박"};
        for (int i = 1; i <= n; i++) {
            answer += wm[(i + 1) % 2];
        }
        return answer;
    }
}