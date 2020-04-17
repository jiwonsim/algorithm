import java.util.*;

class Truck {
    int weight;
    int time;

    Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

class Solution {
    public int solution(int bridgeLen, int weight, int[] trucks) {
        int answer = 0;

        // initialize Riding Truck Que
        Queue<Truck> ridingQue = new LinkedList<>();
        int ridingWeight = 0;

        int index = 0, time = 1;
        while (index < trucks.length && ridingWeight + trucks[index] <= weight) {
            ridingWeight += trucks[index];
            ridingQue.add(new Truck(trucks[index], time));
            index++; time++;
        }

        time--; // in while loop, i will add 1 to time.
        while (!ridingQue.isEmpty()) {
            Truck former = ridingQue.poll();
            time = former.time + bridgeLen > time + 1 ? former.time + bridgeLen : time + 1;

            ridingWeight -= former.weight;

            while (index < trucks.length && ridingWeight + trucks[index] <= weight) {
                ridingWeight += trucks[index];
                ridingQue.add(new Truck(trucks[index], former.time + bridgeLen > time ? former.time + bridgeLen : time));
                index++;
            }
        }

        return time;
    }
}