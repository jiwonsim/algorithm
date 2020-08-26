import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    static Jewel[] jewels;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        jewels = new Jewel[N];
        bags = new int[M];

        for(int i = 0; i < N; i++) {
            String[] jewelsInput = br.readLine().split(" ");

            int wi = Integer.parseInt(jewelsInput[0]);
            int vi = Integer.parseInt(jewelsInput[1]);

            jewels[i] = new Jewel(wi, vi);
        }

        for(int j = 0; j < M; j++) {
            int weightOfBack = Integer.parseInt(br.readLine());
            bags[j] = weightOfBack;
        }

        // 무게를 오름차순으로 정렬한다.
        Arrays.sort(jewels);
        Arrays.sort(bags);

        long result = 0;
        int indexOfJewel = 0;

        for (int i = 0; i < M; i++) {
            // 가방을 기준으로 탐색

            // 가방에 넣을 수 있는 주얼리를 다 넣기
            while(indexOfJewel < N && jewels[indexOfJewel].weight <= bags[i]) {
                pq.add(jewels[indexOfJewel].value);
                indexOfJewel++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        // 가방의 무게를 오름차순으로 정렬하고
        // 보석의 가치를 담은 큐를 내림차순으로 정렬했기 때문에
        // 가장 작은 가방에 넣을 수 있는 큰 가치의 보석을
        // 차례로 하나씩 넣을 수가 있다. 

        bw.write(result + "");
        bw.flush();

    }
}

class Jewel implements Comparable<Jewel> {
    int weight, value;

    Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel target) {
        return this.weight > target.weight ? 1 : -1;
    }
}