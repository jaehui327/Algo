import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Position {
		int x;
		int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, K, maxHeight, answer, cnt;
	static int[] dx = { 1, 0, -1 ,0 }, dy = { 0, -1, 0, 1 };
	static int[][] board;
	static boolean[][] visited;
	static List<Position> peaks;
	
	private static void construction(int x, int y, int k) {
		int height = board[y][x];
		board[y][x] -= k;
		for (int i = 0; i < peaks.size(); i++) {
			cnt = 0;
			visited = new boolean[N][N];
			dfs(peaks.get(i).x, peaks.get(i).y, visited);
		}
		board[y][x] = height;
	}
	
	private static void dfs(int x, int y, boolean[][] visited) {
		visited[y][x] = true;
		cnt += 1;
		answer = Math.max(answer, cnt);
		int nx, ny;
		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[ny][nx] || board[ny][nx] >= board[y][x]) continue;
			dfs(nx, ny, visited);
		}
		visited[y][x] = false;
		cnt -= 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxHeight = 0;
			answer = 0;
			
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (maxHeight < board[i][j]) {
						maxHeight = board[i][j];
						peaks = new ArrayList<>();
					}
					if (maxHeight == board[i][j])
						peaks.add(new Position(j, i));
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= K; k++) {
						construction(j, i, k);
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(answer).append("\n");
		}
		
		
		br.close();
		System.out.println(sb.toString());
	}

}
