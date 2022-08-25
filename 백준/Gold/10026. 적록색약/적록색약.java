import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
// https://www.acmicpc.net/problem/10026
public class Main {

	static int N;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static char[][] board;
	static boolean[][] visited;

	private static int findGroup() {
		int result = 0;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result++;
					bfs(new Position(j, i));
				}
			}
		}

		return result;
	}

	private static int findGroupWeakness() {
		int result = 0;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'G') board[i][j] = 'R';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result++;
					bfs(new Position(j, i));
				}
			}
		}

		return result;
	}
	
	private static void bfs(Position p) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.y][p.x] = true;

		while (!queue.isEmpty()) {
			Position cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || board[ny][nx] != board[cur.y][cur.x])
					continue;
				queue.offer(new Position(nx, ny));
				visited[ny][nx] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		sb.append(findGroup());
		sb.append(" ");
		sb.append(findGroupWeakness());

		br.close();
		System.out.println(sb);
	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
