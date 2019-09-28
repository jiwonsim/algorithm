import java.util.*;

class Solution {
    class Pair {
        String str;
        int cnt;

        Pair(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    boolean diffOne(String str, String comp) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != comp.charAt(i)) cnt++;
        }

        if (cnt == 1) return true;
        return false;
    }

    int bfs(String begin, String target, String[] words) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.add(new Pair(begin, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.str.equals(target)) return p.cnt;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (!diffOne(p.str, words[i])) continue;

                q.add(new Pair(words[i], p.cnt + 1));
                visited[i] = true;
            }
        }

        return 0;
    }

    public int solution(String begin, String target, String[] words) {

        return bfs(begin, target, words);
    }
}