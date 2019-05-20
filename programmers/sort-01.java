import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int check(int[] arr, int[] cmd) {
        List<Integer> list = new ArrayList<>();
        for (int i = cmd[0] - 1; i < cmd[1]; i++) {
            list.add(arr[i]);
        }

        Collections.sort(list);
        return list.get(cmd[2] - 1);
    }

    public int[] solution(int[] array, int[][] commands) {


        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            int [] temp = array;
            ansList.add(check(temp, commands[i]));
        }

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
