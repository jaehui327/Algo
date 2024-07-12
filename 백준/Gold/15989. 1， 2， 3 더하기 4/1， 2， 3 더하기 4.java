import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        for (int t= 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            sb.append((n * (n + 6) + 12) / 12).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}