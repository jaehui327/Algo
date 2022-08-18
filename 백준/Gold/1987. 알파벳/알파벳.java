import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
// https://www.acmicpc.net/problem/1987
public class Main {

	static int R, C, max;
	static int[] dr = { 0, -1, 0, 1 }, dc = { 1, 0, -1, 0 };
	static int[][] visited;
	static char[][] board;

	private static void alphabet(int r, int c, int count, int selected) {
		max = Math.max(max, count);
		visited[r][c]= selected;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && (selected & 1 << (board[nr][nc] - 'A')) == 0 && visited[nr][nc] != (selected | 1 << (board[nr][nc] - 'A'))) {
				alphabet(nr, nc, count + 1, selected | 1 << (board[nr][nc] - 'A'));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 1;
		visited = new int[R][C];
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		alphabet(0, 0, max, 1 << (board[0][0] - 'A'));
		sb.append(max);

		br.close();
		System.out.println(sb);
	}
}
