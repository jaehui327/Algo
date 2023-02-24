import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Position {
		int x;
		int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, maxHeight, answer;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map, water, visited;
	
	private static void solution() {
		if (N < 3 || M < 3) return;
		for (int h = maxHeight; h > 0; h--) {
			visited = new int[N][M];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (visited[i][j] != 0 || water[i][j] != 0 || map[i][j] >= h) continue;
					int value = bfs(h, j, i) ? h : -1;
					fillVisited(h, value);
				}
			}
			fillWater(h);
		}
		sum();
	}
	
	private static boolean bfs(int height, int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		
		queue.offer(new Position(x, y));
		visited[y][x] = -2;
		
		boolean isAvailable = true;
		
		while (!queue.isEmpty()) {
			Position cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					isAvailable = false;
					continue;
				}
				if (water[ny][nx] != 0 || visited[ny][nx] != 0 || map[ny][nx] >= height) continue;
				
				queue.offer(new Position(nx, ny));
				visited[ny][nx] = -2;
				
			}
		}
		
		return isAvailable;
		
	}
	
	private static void fillVisited(int height, int value) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == -2) visited[i][j] = value;
			}
		}
	}
	
	private static void fillWater(int height) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] > 0) water[i][j] = height - map[i][j];
			}
		}
	}
	
	private static void sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += water[i][j];
			}
		}
		answer = sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		water = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j] - '0';
				if (map[i][j] > maxHeight) maxHeight = map[i][j];
			}
		}
		
		solution();
		
		System.out.println(answer);
		br.close();
	}

}
