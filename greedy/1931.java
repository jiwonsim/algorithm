import java.util.*;
import java.io.*;

class Time {
    int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] times = br.readLine().split(" ");
            list.add(new Time(Integer.valueOf(times[0]), Integer.valueOf(times[1])));
        }

        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.end == o2.end)
                    return Integer.compare(o1.start, o2.start);
                return Integer.compare(o1.end, o2.end);
            }
        });

        int before = -1, count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start >= before) {
                before = list.get(i).end;
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}