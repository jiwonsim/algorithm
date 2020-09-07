import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bomb = br.readLine();

        int length = input.length();

        Character[] array = new Character[length];

        int index = 0;
        for (int i = 0; i < length; i++) {
            array[index] = input.charAt(i);
            if (isBomb(array, index, bomb)) { index -= bomb.length(); }
            index += 1;
        }

        if (index == 0) {
            bw.write("FRULA");
        }
        else {
            for (int i = 0; i < index; i++) {
                bw.write(array[i]);
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean isBomb(Character[] array, int index, String bomb) {
        if (index < bomb.length() - 1) { return false; }
        for (int i = 0; i < bomb.length(); i++) {
            if (array[i+index-bomb.length()+1] != bomb.charAt(i)) { return false; }
        }
        return true;
    }
}