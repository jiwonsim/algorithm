class Solution {

    public int solution(int[] stones, int k) {

        int start = 1, end = 1;
        int answer = 1;

        // 가장 큰 수를 갖는 end 값 초기화
        for (int i = 0; i < stones.length; i++) {
            start = Math.min(start, stones[i]);
            end = Math.max(end, stones[i]);
        }


        // 돌길이 한 개일 때
        if (stones.length == 1) {
            return stones[0];
        }

        // 이분 탐색
        while (start <= end) {
            int middle = (start + end) / 2;

            if (isAbleToJump(middle, stones, k)) { // 뛸 수 있다.
                start = middle + 1;
            }
            else { // 뛸 수 없다.
                answer = middle;
                end = middle - 1;
            }
        }

        return answer;
    }

    boolean isAbleToJump(int value, int[] stones, int k) {
        int count = 0, max = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] <= value) {
                count++;
                max = Math.max(count, max);
            }
            else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        return max < k;
    }
}