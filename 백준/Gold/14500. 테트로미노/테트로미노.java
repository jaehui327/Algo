import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][][] tetromino = {
            {{1, 0}, {2, 0}, {3, 0}},
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {0, 1}, {1, 1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, -1}, {1, -1}, {2, -1}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {1, -2}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, -1}, {0, -2}, {1, -2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, -1}, {1, -1}, {1, -2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {1, -1}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
            {{0, 1}, {0, 2}, {1, 1}}
    };


    private static int solution() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, draw(j, i));
            }
        }
        return answer;
    }

    private static int draw(int x, int y) {
        int max = 0;
        for (int i = 0; i < tetromino.length; i++) {
            int sum = map[y][x];
            for (int j = 0; j < 3; j++) {
                int nx = x + tetromino[i][j][0];
                int ny = y + tetromino[i][j][1];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    sum = 0;
                    break;
                }
                sum += map[ny][nx];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(solution());

        System.out.println(sb.toString());
        br.close();
    }

}