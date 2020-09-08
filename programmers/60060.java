import java.util.*;

class TrieNode {
    Character value;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;
    int count;

    TrieNode(Character value) {
        this.value = value;
        this.children = new HashMap<>();
        this.isLeaf = false;
        this.count = 0;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
            current.setCount(current.getCount()+1);
            current = current.children.get(c);
        }
        current.setLeaf(true);
    }

    int counting(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (c == '?') { return current.count; }
            if (current.children.get(c) == null) { return 0; }

            current = current.children.get(c);
        }
        return current.count;
    }
}

class Solution {

    String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    public int[] solution(String[] words, String[] queries) {

        int digit = 100000;

        // 트라이 배열 초기화
        Trie[] wordList = new Trie[digit+1]; // 접미사가 물음표인 트라이 배열
        Trie[] reversedList = new Trie[digit+1]; // 접두사가 물음표인 트라이 배열
        for (int i = 0; i <= digit; i++) {
            wordList[i] = new Trie();
            reversedList[i] = new Trie();
        }

        for (String word : words) {
            int length = word.length();
            wordList[length].insert(word);
            reversedList[length].insert(reverse(word));
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int length = query.length();

            if (query.charAt(0) == '?') { // 접두사가 물음표
                result[i] = reversedList[length].counting(reverse(query));
            }
            else { // 접미사가 물음표
                result[i] = wordList[length].counting(query);
            }
        }

        return result;
    }
}