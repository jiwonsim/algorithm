import java.util.*;

class Pair {
    int location, priority;

    Pair(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> printer = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            printer.add(new Pair(i, priorities[i]));
            pq.add(priorities[i]);
        }

        int order = 1;
        while (!printer.isEmpty()) {
            Pair curPrint = printer.poll();

            if (curPrint.priority != pq.peek()) {
                // 프린트할 중요도가 아니면 printer 큐에 다시 add
                printer.add(curPrint);
            }
            else {
                // 내가 알고 싶은 순서의 프린트라면 순서 반환하고 끝
                if (location == curPrint.location) {
                    return order;
                }
                // 내가 알고 싶은 순서가 아니면 pop하고 order+1
                else {
                    pq.poll();
                    order++;
                }
            }
        }

        return answer;
    }
}