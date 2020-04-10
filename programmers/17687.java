class Solution {
    StringBuffer tubes = new StringBuffer();

    Character[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    String conversion(int input, int n) {
        if (input == 0) return "0";
        String str = "";

        int quo = input / n, rem = input % n; // quo : 몫, rem : 나머지
        while (true) {
            if (quo >= n) {
                str = nums[rem] + str;
                rem = quo % n;
                quo = quo / n;
            }
            else {
                str = nums[rem] + str;
                if (quo != 0) str = nums[quo] + str;
                break;
            }
        }

        return str;
    }

    public String solution(int n, int t, int m, int p) {
        int order = 0, tubeOrder = 0;

        while (tubes.length() < t) {
            String str = conversion(order, n);
            for (char c : str.toCharArray()) {
                tubeOrder++;
                if (tubeOrder == p) {
                    tubes.append(c);
                    if (tubes.length() == t) return tubes.toString();
                }
                if (tubeOrder == m) tubeOrder = 0;
            }
            order++;
        }

        return tubes.toString();
    }
}