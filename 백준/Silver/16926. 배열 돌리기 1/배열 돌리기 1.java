import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16926. 배열 돌리기 1
// https://www.acmicpc.net/problem/16926
public class Main {

	static int N, M, R;
	static int[][] board;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static void leftRotate() {
		int line = Math.min(N, M) / 2;
		for (int i = 0; i < line; i++) {
			int start = board[i][i];
			int r = i;
			int c = i;
			int d = 0;
			while(d < 4) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				
				if(nr >= i && nr < N - i && nc >= i && nc < M - i) {
					board[r][c] = board[nr][nc];
					r = nr;
					c = nc;
				} else d++;
			}
			board[i + 1][i] = start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			leftRotate();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
