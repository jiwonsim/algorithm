class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            if (answer[i].length() < n) {
                while (answer[i].length() < n) {
                    answer[i] = "0" + answer[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String in = "";
            for (int j = 0; j < n; j++) {
                if (answer[i].charAt(j) == '1') {
                    in += "#";
                }
                else in += " ";
            }
            answer[i] = in;
        }

        return answer;
    }
}