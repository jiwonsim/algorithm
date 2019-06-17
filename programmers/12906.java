import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        int before = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (before != arr[i]) {
                list.add(arr[i]);
            }
            before = arr[i];
        }

        answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }
}