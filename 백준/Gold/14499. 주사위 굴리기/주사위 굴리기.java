import java.io.*;
import java.util.*;

public class Main {

    static int N, M, x, y;
    static int[][] map;
    static int[] dice;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, -1, 1 };
    static int[][] dd = { { 1, 5, 0, 3, 4, 2 }, { 2, 0, 5, 3, 4, 1 }, { 4, 1, 2, 0, 5, 3 }, { 3, 1, 2, 5, 0, 4 } };


    static int moveDice(int command) {
        int nx = x + dx[command];
        int ny = y + dy[command];
        if (nx < 0 || nx >= M || ny < 0 || ny >= N) return -1;

        x = nx; y = ny;
        int[] copy = new int[6];
        for (int i = 0; i < 6; i++) copy[i] = dice[dd[command][i]];
        dice = copy.clone();

        if (map[y][x] == 0) map[y][x] = dice[0];
        else {
            dice[0] = map[y][x];
            map[y][x] = 0;
        }
        return dice[5];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dice = new int[6];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int command, answer;
        for (int i = 0; i < K; i++) {
            command = Integer.parseInt(st.nextToken());
            answer = moveDice(command - 1);
            if (answer == -1) continue;
            else sb.append(answer).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}