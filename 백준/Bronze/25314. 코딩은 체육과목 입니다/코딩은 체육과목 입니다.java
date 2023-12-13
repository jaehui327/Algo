import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < N / 4; i++) {
            sb.append("long ");
        }
        sb.append("long int");
        System.out.println(sb.toString());
        br.close();
    }
}