import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static int[] dr = { 0, -1, 0, 1 }, dc = { 1, 0, -1, 0 };
	static char[][] board;

	private static void alphabet(int r, int c, int count, boolean[][] visited, boolean[] selected) {
		visited[r][c] = true;
		selected[board[r][c] - 'A'] = true;
		max = Math.max(max, count);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && !selected[board[nr][nc] - 'A']) {
				alphabet(nr, nc, count + 1, visited, selected);
			}
		}
		visited[r][c] = false;
		selected[board[r][c] - 'A'] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		alphabet(0, 0, 1, new boolean[R][C], new boolean[26]);
		sb.append(max);

		br.close();
		System.out.println(sb);
	}
}
