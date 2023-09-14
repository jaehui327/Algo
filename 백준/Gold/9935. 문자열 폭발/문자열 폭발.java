import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Boolean isBomb;

        String str = br.readLine();
        String bomb = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bomb.length()) {
                isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }

        if (sb.length() > 0) System.out.println(sb);
        else System.out.println("FRULA");
        br.close();
    }
}