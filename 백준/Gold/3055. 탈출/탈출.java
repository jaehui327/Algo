import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
// https://www.acmicpc.net/problem/3055
class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int R, C;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static char[][] board;
	static boolean[][] visited, isWater;
	static Queue<Position> queue, wq;
	
	private static int bfs() {
		int result = 0;
		
		while (!queue.isEmpty()) {
			result++;
			wq = expandWater(wq);
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Position p = queue.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || board[ny][nx] == 'X' || board[ny][nx] == '*') continue;
					if (board[ny][nx] == 'D') return result;
					queue.offer(new Position(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}
		
		return -1;
	}
	
	private static Queue<Position> expandWater(Queue<Position> wq) {
		int size = wq.size();
		for (int i = 0; i < size; i++) {
			Position w = wq.poll();
			for (int j = 0; j < 4; j++) {
				int nx = w.x + dx[j];
				int ny = w.y + dy[j];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C || isWater[ny][nx] || board[ny][nx] == 'X' || board[ny][nx] == 'D') continue;
				board[ny][nx] = '*';
				wq.offer(new Position(nx, ny));
				isWater[ny][nx] = true;
			}
		}
		return wq;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		visited = new boolean[R][C];
		isWater = new boolean[R][C];
		queue = new LinkedList<Position>();
		wq = new LinkedList<Position>();
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'S') {
					queue.offer(new Position(j, i));
					visited[i][j] = true;
				}
				else if (board[i][j] == '*') {
					wq.offer(new Position(j, i));
					isWater[i][j] = true;
				}
			}
		}
		
		int answer = bfs();
		if (answer == -1) sb.append("KAKTUS");
		else sb.append(answer);

		br.close();
		System.out.println(sb);
	}
}
