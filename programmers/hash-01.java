import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (participant[i].equals(completion[i])) continue;
            answer = participant[i]; break;

        }


        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};

        System.out.println(s.solution(participant, completion));
    }
}