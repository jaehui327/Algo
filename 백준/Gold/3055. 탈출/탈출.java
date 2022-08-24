import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

	private static int bfs(Position s, List<Position> water) {
		int result = 0;
		Queue<Position> queue = new LinkedList<Position>();
		visited = new boolean[R][C];
		Queue<Position> wq = new LinkedList<Position>();
		isWater = new boolean[R][C];
		
		queue.offer(s);
		visited[s.y][s.x] = true;
		
		for (int i = 0; i < water.size(); i++) {
			wq.offer(new Position(water.get(i).x, water.get(i).y));
		}
		
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
		
		List<Position> water = new ArrayList<Position>();
		Position s = null;
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'S') s = new Position(j, i);
				else if (board[i][j] == '*') water.add(new Position(j, i));
			}
		}
		
		int answer = bfs(s, water);
		if (answer == -1) sb.append("KAKTUS");
		else sb.append(answer);

		br.close();
		System.out.println(sb);
	}
}
