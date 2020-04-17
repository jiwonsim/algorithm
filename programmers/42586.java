import java.util.*;

class Solution {
    int[] spentTimes;

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> workCnt = new ArrayList<>();

        // 소요시간 배열 초기화
        initSpentTimes(progresses, speeds);

        // 동시 업무 시간 계산
        int i = 0, j = 0;
        for (i = 0; i < progresses.length;) {
            int curTime = spentTimes[i];

            int count = 1;
            for (j = i + 1; j < progresses.length; j++) {
                if (spentTimes[j] > curTime) break;
                count++;
            }

            workCnt.add(count);
            // 검사했던 부분의 다음으로 넘어가기
            i = j;
        }

        return convertList2Array(workCnt);
    }

    void initSpentTimes(int[] progresses, int[] speeds) {
        spentTimes = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            spentTimes[i] = (100 - progresses[i]) / speeds[i];
        }
    }

    int[] convertList2Array(ArrayList<Integer> list) {
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}