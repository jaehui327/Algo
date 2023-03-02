import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x;
        int y;
        int distance;
        int k;

        Pos(int x, int y, int distance, int k) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.k = k;
        }
    }

    static int N, M, K, answer;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static char[][] board;

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        int[][][] visited = new int[N][M][K + 1];
        queue.add(new Pos(0, 0, 1, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (nx == M - 1 && ny == N - 1) answer = Math.min(answer, cur.distance + 1);
                if (visited[ny][nx][cur.k] > 0) continue;

                if (board[ny][nx] == '0') {
                    visited[ny][nx][cur.k] = cur.distance + 1;
                    queue.offer(new Pos(nx, ny, cur.distance + 1, cur.k));
                } else {
                    if (cur.k == K) continue;
                    if (visited[ny][nx][cur.k + 1] > 0) continue;
                    visited[ny][nx][cur.k + 1] = cur.distance + 1;
                    queue.offer(new Pos(nx, ny, cur.distance + 1, cur.k + 1));
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        bfs();
        if (answer == Integer.MAX_VALUE) answer = -1;
        if (N == 1 && M == 1) answer = 1;
        sb.append(answer);

        System.out.println(sb.toString());
        br.close();
    }

}
