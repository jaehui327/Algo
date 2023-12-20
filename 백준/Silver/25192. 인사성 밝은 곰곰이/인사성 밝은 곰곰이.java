import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        String s;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            if (s.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }

            if (!set.contains(s)) {
                answer++;
                set.add(s);
            }
        }

        System.out.println(answer);
        br.close();
    }
}