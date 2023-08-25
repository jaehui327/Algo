import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] map;
    static int[][] groupMap;
    static Map<Integer, Integer> group;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

    static int bfs(int x, int y, int groupNum) {
        Queue<Point> queue = new LinkedList<>();
        groupMap[y][x] = groupNum;
        queue.offer(new Point(x, y));
        int cnt = 1;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (map[ny][nx] == '1' || groupMap[ny][nx] > 0) continue;
                cnt += 1;
                groupMap[ny][nx] = groupNum;
                queue.offer(new Point(nx, ny));
            }
        }

        return cnt;
    }

    static int print(int x, int y) {
        if (map[y][x] == '0') return 0;

        int sum = 1;
        Set<Integer> set = new HashSet<>();

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (map[ny][nx] == '1' || groupMap[ny][nx] == 0) continue;
            set.add(groupMap[ny][nx]);
        }

        for (int i : set)
            sum += group.get(i);

        return sum % 10;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        groupMap = new int[N][M];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        int groupNum = 1;
        group = new HashMap<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == '0' && groupMap[i][j] == 0) {
                    group.put(groupNum, bfs(j, i, groupNum));
                    groupNum += 1;
                }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(print(j, i));
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}