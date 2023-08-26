import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static char[][] map;
    static List<Point> blanks;
    static List<Point> teachers;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
    static boolean isAvailable;

    static void combination(int idx, int cnt) {
        if (isAvailable) return;
        if (cnt == 3) {
            check();
            return;
        }

        for (int i = idx; i < blanks.size(); i++) {
            map[blanks.get(i).y][blanks.get(i).x] = 'O';
            combination(i + 1, cnt + 1);
            map[blanks.get(i).y][blanks.get(i).x] = 'X';
        }
    }

    static void check() {
        for (int i = 0; i < teachers.size(); i++) {
            for (int d = 0; d < 4; d++) {
                int x = teachers.get(i).x;
                int y = teachers.get(i).y;
                while (true) {
                    x += dx[d];
                    y += dy[d];
                    if (x < 0 || x >= N || y < 0 || y >= N) break;
                    if (map[y][x] == 'O') break;
                    if (map[y][x] == 'S') return;
                }
            }
        }
        isAvailable = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        blanks = new ArrayList<>();
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'X') blanks.add(new Point(j, i));
                if (map[i][j] == 'T') teachers.add(new Point(j, i));
            }
        }

        combination(0, 0);
        if (isAvailable) System.out.println("YES");
        else System.out.println("NO");

        br.close();
    }
}