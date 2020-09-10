import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split("::"); // "::"로 나눈다.

        ArrayList<String> result = extend(input[0].split(":"));
        int insertingIndex = result.size();
        if (input.length > 1) {
            ArrayList<String> back = extend(input[1].split(":"));
            for (String element : back) {
                result.add(element);
            }
        }

        while (result.size() < 8) {
            result.add(insertingIndex, "0000");
        }

        for (int i = 0; i < result.size(); i++) {
            writer.write(result.get(i));
            if (i != result.size()-1) {
                writer.write(":");
            }
        }
        writer.flush();
    }

    static ArrayList<String> extend(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            while (word.length() < 4) {
                word = '0' + word;
            }
            result.add(word);
        }
        return result;
    }
}