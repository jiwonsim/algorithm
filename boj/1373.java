import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String binaryInput = br.readLine();
        int length = binaryInput.length();

        StringBuilder result = new StringBuilder();
        if (length % 3 == 1) result.append(binaryInput.charAt(0));
        else if (length % 3 == 2)
            result.append((binaryInput.charAt(0) - '0') * 2 +
                    (binaryInput.charAt(1) - '0') * 1);

        for (int i = length % 3; i < length; i += 3) {
            result.append((binaryInput.charAt(i) - '0') * 4
                    + (binaryInput.charAt(i + 1) - '0') * 2
                    + (binaryInput.charAt(i + 2) - '0') * 1);
        }

        bw.write(result.toString());
        bw.flush();
    }
}