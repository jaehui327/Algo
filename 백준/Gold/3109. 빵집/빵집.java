import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static char[][] board;
	static int[] dr = { -1, 0, 1 }, dc = { 1, 1, 1 };

	private static boolean bakery(int r, int c) {
		board[r][c] = '0';
		if (c == C - 1) return true;
			
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && board[nr][nc] == '.') {
				if (bakery(nr, nc)) return true;
			}
		}
		return false;
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

		for (int i = 0; i < R; i++) {
			if (bakery(i, 0)) max++;
		}
		sb.append(max);

		br.close();
		System.out.println(sb);
	}
}
