import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Map<Integer, Integer> cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        cards = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (cards.containsKey(num)) {
                cards.put(num, cards.get(num) + 1);
            } else {
                cards.put(num, 1);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (cards.containsKey(card)) {
                sb.append(cards.get(card));
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
        br.close();
    }

}