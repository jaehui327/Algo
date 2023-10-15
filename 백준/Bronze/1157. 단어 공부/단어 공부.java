import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int max = -1;
        char answer = 0;
        for (Character key: map.keySet()) {
            if (max < map.get(key)) {
                answer = key;
                max = map.get(key);
            } else if (max == map.get(key))
                answer = '?';
        }

        System.out.println(answer);
        br.close();
    }


}