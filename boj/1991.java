import java.util.*;

public class Main {
    static int N;
    static HashMap<String, ArrayList<String>> hm;
    static boolean[] visited;
    public static void preorder(String start) {
        System.out.printf("%s", start);
        visited[start.charAt(0) - 'A'] = true;

        for (String val : hm.get(start)) {
            if (val.equals(".")) continue;
            visited[start.charAt(0) - 'A'] = true;
            preorder(val);
            visited[start.charAt(0) - 'A'] = false;
        }
    }

    public static void inorder(String start) {
        if (visited[start.charAt(0) - 'A']) return;
        String before = "";

        for (String val : hm.get(start)) {
            if (!val.equals(".")) {
                before = val;
                continue;
            }
            System.out.printf("index : %d \n", before.charAt(0) - 'A');
            visited[before.charAt(0) - 'A'] = true;
            inorder(before);
            visited[before.charAt(0) - 'A'] = false;
        }
    }

    public static void postorder(String start) {

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        hm = new HashMap<>();
        visited = new boolean[N + 1];
        ArrayList<String> val;
        String key;
        for (int i = 0; i < N; i++) {
            key = sc.next();
            if (hm.get(key) == null) {
                val = new ArrayList<>();
            }
            else {
                val = hm.get(key);
            }
            for (int j = 0; j < 2; j++) {
                val.add(sc.next());
            }
            hm.put(key, val);
        }

//        for (String k : hm.keySet()) {
//            System.out.printf("%s ", k);
//            for (String v : hm.get(k))
//                System.out.printf("%s ", v);
//            System.out.printf("\n");
//        }

        preorder("A");
        System.out.printf("\n");
        for (String k : hm.keySet()) {
            inorder(k);
        }
//        Arrays.fill(visited, false);
//        postorder("A");
    }
}