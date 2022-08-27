import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미세먼지 안녕!
// https://www.acmicpc.net/problem/17144
public class Main {
	
	static int R, C, T, rotateRow;
	static int[] dr = { -1 , 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] board;
	
	private static void diffusion() {
		int[][] copy = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] <= 0) continue;
				int count = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == -1) continue;
					count++;
					copy[nr][nc] += board[r][c] / 5;
				}
				board[r][c] -= board[r][c] / 5 * count;
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				board[r][c] += copy[r][c];
			}
		}
	}
	
	private static void rotateCounterClockWise(int[] dr) {
		int r = rotateRow - 1;
		int c = 0;
		int d = 0;
		while (d < 4) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr <= rotateRow && nc >= 0 && nc < C) {
				if (board[nr][nc] == -1) board[r][c] = 0;
				else board[r][c] = board[nr][nc];
				r = nr; c = nc;
			} else d++;
		}
	}
	
	private static void rotateClockWise(int[] dr) {
		int r = rotateRow + 2;
		int c = 0;
		int d = 0;
		while (d < 4) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr > rotateRow && nr < R && nc >= 0 && nc < C) {
				if (board[nr][nc] == -1) board[r][c] = 0;
				else board[r][c] = board[nr][nc];
				r = nr; c = nc;
			} else d++;
		}
	}
	
	private static int getDust() {
		int result = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				result += board[r][c];
			}
		}
		return result + 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		for(int i = 0; i < R; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
				if (board[i][j] == -1) rotateRow = i - 1;
			}
		}
		
		for (int i = 0; i < T; i++) {
			diffusion();
			rotateCounterClockWise(new int[]{ -1, 0, 1, 0 });
			rotateClockWise(new int[]{ 1, 0, -1, 0 });
		}
		
		sb.append(getDust());
		
		br.close();
		System.out.println(sb);
	}
}
