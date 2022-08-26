import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
// https://www.acmicpc.net/problem/4485
public class Main {
	
	static class Position {
		int x;
		int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static int[][] board, dp;
	
	private static int zelda() {
		dp = new int[N][N];
		for (int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
		Queue<Position> queue = new LinkedList<>();
		
		queue.add(new Position(0, 0));
		dp[0][0] = board[0][0];
		
		while (!queue.isEmpty()) {
			Position p = queue.poll();
			if (dp[p.y][p.x] < board[p.y][p.x]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				int nw = dp[p.y][p.x] + board[ny][nx];
				if (dp[ny][nx] > nw) {
					dp[ny][nx] = nw;
					queue.add(new Position(nx, ny));
				}
				
			}
		}
		
		return dp[N - 1][N - 1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem ").append(t++).append(": ");
			sb.append(zelda()).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
