import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static class Position {
		int y;
		int x;
		
		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, K, max, highest;
	static int[] dy = { -1 , 0, 1, 0 }, dx = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Position> peaks;
	
	private static void hikingTrail() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int temp = board[y][x];
				for (int k = 0; k <= K; k++) {
					board[y][x] = temp - k;
					move();
				}
				board[y][x] = temp;
			}
		}
	}
	
	private static void move() {
		for (Position peak : peaks) {
			visited = new boolean[N][N];
			visited[peak.y][peak.x] = true;
			dfs(peak.y, peak.x, 1);
		}
	}
	
	private static void dfs(int y, int x, int route) {
		max = Math.max(max, route);
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && board[ny][nx] < board[y][x]) {
				visited[ny][nx] = true;
				dfs(ny, nx, route + 1);
				visited[ny][nx] = false;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			highest = 0;
			
			board = new int[N][N];
			peaks = new ArrayList<>();
			
			for (int y = 0; y < N; y++) {
				StringTokenizer s = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					board[y][x] = Integer.parseInt(s.nextToken());
					if (board[y][x] > highest) {
						highest = board[y][x];
						peaks.clear();
						peaks.add(new Position(y, x));
					} else if (board[y][x] == highest) peaks.add(new Position(y, x));
				}
			}

			hikingTrail();
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
