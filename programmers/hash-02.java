import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        int MinLen = Integer.MAX_VALUE;
        String prefix = "";
        for (String phone : phone_book) {
            if (MinLen >= phone.length()) {
                MinLen = phone.length();
                prefix = phone;
            }
            else {
                if (phone.substring(0, MinLen).equals(prefix)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}