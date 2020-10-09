class Solution {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        
        int[] numbers = {4, 1, 2};
        
        while (n > 0) {
            answer.insert(0, numbers[n % 3]); 
            if (n % 3 == 0) { n = n/3 - 1; } 
            else { n /= 3; }
        }
        
        return answer.toString();
    }
}
