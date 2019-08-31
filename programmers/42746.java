import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) numStrs[i] = String.valueOf(numbers[i]);

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        };

        Arrays.sort(numStrs, comp);
        for (int i = 0; i < numStrs.length; i++) answer += numStrs[i];
        if (numStrs[0].equals("0")) answer = "0";


        return answer;
    }
}