import java.util.*;
import java.io.*;

class Pair {
    String content;
    int length;

    Pair (String content) {
        this.content = content;
        this.length = content.length();
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Comparator<Pair> comp = new Comparator<Pair>() {
        @Override
        public int compare(Pair p1, Pair p2) {
            // if they have different length
            if (p1.length == p2.length) {
                // in alphabetical order
                return p1.content.compareTo(p2.content);
            }
            else return p1.length - p2.length; // in length order
        }
    };

    public static void main(String[] args) throws IOException {
        // initializing
        int N = Integer.valueOf(br.readLine());

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String content = br.readLine();
            list.add(new Pair(content));
        }

        // sorting
        Collections.sort(list, comp);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            // check duplication
            if (i > 0 && list.get(i).content.equals(list.get(i - 1).content))
                continue;
            sb.append(list.get(i).content + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}