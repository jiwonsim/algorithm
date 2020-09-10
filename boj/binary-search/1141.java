import java.io.*;
import java.util.*;

class TrieNode {
    Character value;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;

    TrieNode(Character value) {
        this.value = value;
        children = new HashMap<>();
        isLeaf = false;
    }

    void add(Character value) {
        children.put(value, new TrieNode(value));
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode(null);
    }

    void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            if (current.children.get(c) == null) {
                current.add(c);
            }
            current = current.children.get(c);
            current.setLeaf(false);
        }
        current.setLeaf(true);
    }

    int searchLeaf(TrieNode node) {
        if (node.isLeaf()) {
            return 1;
        }

        int result = 0;
        for (Character key : node.children.keySet()) {
            result += searchLeaf(node.children.get(key));
        }
        return result;
    }

    int countLeaf() {
        return searchLeaf(root);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] =reader.readLine();
        }
        Arrays.sort(inputs);

        Trie trie = new Trie();
        for (String element : inputs) {
            trie.insert(element);
        }
        writer.write(trie.countLeaf() + "\n");
        writer.flush();
    }
}