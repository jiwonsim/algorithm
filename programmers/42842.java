class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for (int h = 1; h <= Math.sqrt(red); h++) {
            if (red % h != 0) continue;

            int size = (h + 2) * (red / h + 2);
            if (size == brown + red) {
                answer[1] = h + 2;
                answer[0] = red / h + 2;
                break;
            }
        }

        return answer;
    }
}