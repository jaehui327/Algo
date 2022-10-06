import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	static int N, max;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] blocks = { 
			{ 2, 3, 0, 1 }, // 벽 
			{ 2, 0, 3, 1 }, // 1
			{ 2, 3, 1, 0 }, // 2
			{ 1, 3, 0, 2 }, // 3
			{ 3, 2, 0, 1 }, // 4
			{ 2, 3, 0, 1 }  // 5
	};
	static int[][] board;
	static Map<Integer, List<Position>> warmholes;
	
	private static void pinball(int x, int y, int d) {
		int nd = d;
		int nx = x + dx[nd];
		int ny = y + dy[nd];
		
		int score = 0;
		while (true) {
			if (nx == x && ny == y) break;
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 벽 
				score += 1;
				nd = blocks[0][nd];
				nx += dx[nd];
				ny += dy[nd];
			} else {
				if (board[ny][nx] == -1)  
					break;
				else if (board[ny][nx] == 0) {
					nx += dx[nd];
					ny += dy[nd];
				} else if (board[ny][nx] >= 1 && board[ny][nx] <= 5) {
					score += 1;
					nd = blocks[board[ny][nx]][nd];
					nx += dx[nd];
					ny += dy[nd];
				} else if (board[ny][nx] >= 6 && board[ny][nx] <= 10) {
					Position p = moveWarmhole(nx, ny, board[ny][nx]);
					nx = p.x + dx[nd];
					ny = p.y + dy[nd];
				}
			}
		}
		
		max = Math.max(max, score);
	}
	
	private static Position moveWarmhole(int x, int y, int n) {
		List<Position> pair = warmholes.get(board[y][x]);
		if (pair.get(0).x == x && pair.get(0).y == y) {
			return pair.get(1);
		} else {
			return pair.get(0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			board = new int[N][N];
			warmholes = new HashMap<Integer, List<Position>>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] >= 6 && board[i][j] <= 10) {
						if (warmholes.containsKey(board[i][j])) {
							warmholes.get(board[i][j]).add(new Position(j, i));
						} else {
							warmholes.put(board[i][j], new ArrayList<Position>());
							warmholes.get(board[i][j]).add(new Position(j, i));
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							pinball(j, i, d);
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(max).append("\n");
		}
		
		br.close();
		System.out.println(sb.toString());
	}

}
