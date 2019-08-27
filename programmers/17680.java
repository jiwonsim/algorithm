import java.util.*;

// 0827 17:23 ~ 19:30

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();

        if (cacheSize == 0) return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i].toLowerCase();

            if (list.contains(curCity)) {
                list.remove(curCity);
                list.add(curCity);
                answer += 1;
            }
            else {
                if (list.size() == cacheSize) {
                    list.removeFirst();
                }
                list.add(curCity);
                answer += 5;
            }
        }

        return answer;
    }
}