import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X, result;
	static int[] dx = { 1, 0 }, dy = { 0, 1 };
	static int[][] board;
	
	private static void construction(int x, int y, int d, int w, boolean check) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (nx >= N || ny >= N) {
			if (!check || ((check && w >= X)))
				result += 1;
			return;
		}
		
		int height = board[ny][nx] - board[y][x];
		
		if (height == 0) {
			if (check && w + 1 == X)
				construction(nx, ny, d, 0, false);
			else 
				construction(nx, ny, d, w + 1, check);
		} else if (height == 1) { // 높아지면 
			if (check) return;
			if (w >= X)
				construction(nx, ny, d, 1, false);
		} else if (height == -1) { // 낮아지면 
			if (check) return;
			if (!check || (check && w >= X))
				construction(nx, ny, d, 1, true);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			result = 0;
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int y = 0; y < N; y++) {
				construction(0, y, 0, 1, false);
			}
			for (int x = 0; x < N; x++) {
				construction(x, 0, 1, 1, false);
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(result).append("\n");
		}
		
		br.close();
		System.out.println(sb.toString());
	}
}
