import java.util.*;

class Solution {
    public boolean isInRange(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    public List<String> initList(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (!isInRange(str.charAt(i)) || !isInRange(str.charAt(i + 1))) continue;

            String tmp = "" + str.charAt(i) + str.charAt(i + 1);

            list.add(tmp);
        }

        return list;
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = initList(str1);
        List<String> list2 = initList(str2);

        List<String> inter = new ArrayList<>(), union = new ArrayList<>();

        int index = 0;
        while (index < list1.size()) {
            String ele = list1.get(index);

            if (list2.contains(ele)) {
                list2.remove(ele);
                list1.remove(ele);
                inter.add(ele);
                union.add(ele);
                index--;
            }
            index++;
        }

        for (String ele : list1) union.add(ele);
        for (String ele : list2) union.add(ele);

        if (union.size() == 0 && inter.size() == 0) return 65536;

        answer = (int)((inter.size() / (double)union.size()) * 65536);


        return answer;
    }
}