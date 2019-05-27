import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort(((a, b) -> (b + a).compareTo(a + b)));

//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }

        for (String list_str : list) {
            answer += list_str;
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}