import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16234
public class Main {
	
	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, L, R;
	static boolean available;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static int[][] board;
	static boolean[][] visited;
	
	private static int move() {
		int result = 0;
		available = true;
		
		while(available) {
			available = false;
			visited = new boolean[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!visited[y][x]) {
						bfs(x, y);
					}
				}
			}
			if (available) result += 1;
		}
		
		return result;
	}
	
	private static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		List<Position> union = new ArrayList<>();
		
		visited[y][x] = true;
		queue.add(new Position(x, y));
		union.add(new Position(x, y));
		
		int sum = 0;
		
		while (!queue.isEmpty()) {
			Position cur = queue.poll();
			int cx = cur.x;
			int cy = cur.y;
			sum += board[cy][cx];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) continue;
				int diff = Math.abs(board[cy][cx] - board[ny][nx]);
				if (diff >= L && diff <= R) {
					available = true;
					visited[ny][nx] = true;
					queue.add(new Position(nx, ny));
					union.add(new Position(nx, ny));
				}
			}
		}
		
		int num = sum / union.size();
		for (int i = 0; i < union.size(); i++) {
			board[union.get(i).y][union.get(i).x] = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		System.out.println(move());
	}

}
