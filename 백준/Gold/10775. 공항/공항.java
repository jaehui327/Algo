import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int G, P;
    static int[] gate;

    private static int docking(int g) {
        if (g == 0) return Integer.MIN_VALUE;
        if (gate[g] == -1) {
            gate[g] = g - 1;
            return gate[g];
        }
        gate[g] = docking(gate[g]);
        return gate[g];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        gate = new int[G + 1];
        Arrays.fill(gate, -1);

        P = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if (docking(g) == Integer.MIN_VALUE)
                break;
            answer += 1;
        }

        System.out.println(answer);
        br.close();
    }

}