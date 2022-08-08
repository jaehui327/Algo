import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

// 1012. 유기농 배추
// https://www.acmicpc.net/problem/1012
public class Main {

	static int M, N, result;
	static boolean[][] board;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static void earthworm() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] && !visited[i][j]) {
					dfs(i, j);
					result++;
				}
			}
		}
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && board[nr][nc] && !visited[nr][nc]) 
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			result = 0;
			board = new boolean[M][N];
			visited = new boolean[M][N];
			int K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				StringTokenizer k = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(k.nextToken());
				int y = Integer.parseInt(k.nextToken());
				board[x][y] = true;
			}

			earthworm();
			sb.append(result);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
