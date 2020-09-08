import java.util.*;

class Solution {

    int countByRange(String left, String right, ArrayList<String> words) {
        int si = Arrays.binarySearch(words.toArray(), left);
        int ei = Arrays.binarySearch(words.toArray(), right);

        if (si < 0 && ei < 0) { return Math.abs(si-ei); }
        else if (si > 0 && ei < 0) { return (ei+1)*(-1) - si; }
        else if (si < 0 && ei > 0) { return (si+1)*(-1) - ei; }
        else { return ei-si+1; }
    }

    String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    Character[] makeCharArr(String str) {
        Character[] result = new Character[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        // 문자열 리스트 초기화
        ArrayList<String>[] wordList = new ArrayList[100001];
        ArrayList<String>[] reversedList = new ArrayList[100001];
        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = new ArrayList<>();
            reversedList[i] = new ArrayList<>();
        }

        // 문자열 리스트 삽입
        for (String word : words) {
            wordList[word.length()].add(word);
            reversedList[word.length()].add(reverse(word));
        }

        for (int i = 0; i < wordList.length; i++) {
            Collections.sort(wordList[i]);
            Collections.sort(reversedList[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            int length = query.length();
            if (query.charAt(0) == '?') {
                // 앞에서부터 물음표가 시작됨 (eg. ????o)
                String reversed = reverse(query);
                String start = reversed.replace('?', 'a');
                String end = reversed.replace('?', 'z');

                answer[i] = countByRange(start, end, reversedList[length]);
            }
            else {
                // 뒤에서부터 물음표가 시작됨 (eg. fro??)
                String start = query.replace('?', 'a');
                String end = query.replace('?', 'z');

                answer[i] = countByRange(start, end, wordList[length]);
            }
        }

        return answer;
    }
}