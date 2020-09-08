import java.util.*;
import java.io.*;

class TrieNode {
    private Character value;
    HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf = false;

    TrieNode(char value) {
        this.value = value;
    }

    TrieNode() {
        this.value = null;
    }

    void add(char value) {
        children.put(value, new TrieNode(value));
        isLeaf = false;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (Character c : word.toCharArray()) {
            if (current.children.get(c) == null) {
                current.add(c);
                current = current.children.get(c);
            }
            else {
                current = current.children.get(c);
            }
        }

        current.setLeaf(true);
    }

    boolean contains(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            current = current.children.get(c);
        }
        return current.isLeaf();
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Trie trie = new Trie();

            String[] input = new String[N];
            for (int i = 0; i < N; i++) {
                input[i] = br.readLine();
            }

            Arrays.sort(input);
            for (String number : input) {
                trie.insert(number);
            }

            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (trie.contains(input[i])) {
                    continue;
                }
                flag = false;
                break;
            }
            if (flag) { bw.write("YES\n"); }
            else { bw.write("NO\n"); }
            bw.flush();
        }
    }
}
