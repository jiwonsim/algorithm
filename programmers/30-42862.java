import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]] = 0;
        }
        for (int j = 0; j < reserve.length; j++) {
            arr[reserve[j]]++;
        }

        for (int k = 1; k < arr.length; k++) {
            if (arr[k] == 0) {
                if (arr[k - 1] == 2) {
                    arr[k - 1] = 1;
                    arr[k] = 1;
                }
            }
            if (arr[k] == 2) {
                if (arr[k - 1] == 0) {
                    arr[k - 1] = 1;
                    arr[k] = 1;
                }
            }
        }

        answer = n;
        for (int l = 1; l < arr.length; l++) {
            if (arr[l] == 0) answer--;
        }

        return answer;
    }
}