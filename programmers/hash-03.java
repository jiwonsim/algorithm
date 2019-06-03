import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<String> list;
        for (String[] c : clothes) {

            if (hm.get(c[1]) == null)  {
                list = new ArrayList<>();
                list.add(c[1]);
                hm.put(c[1], list);
            }
            else {
                list = hm.get(c[1]);
                list.add(c[1]);
                hm.put(c[1], list);
            }
        }

        int answer = 1;

        for (String key : hm.keySet()) {
            answer *= (hm.get(key).size() + 1);
        }

        answer--;

        return answer;
    }
}