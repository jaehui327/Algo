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
		int isBreak;
		
		Position(int x, int y, int isBreak) {
			this.x = x;
			this.y = y;
			this.isBreak = isBreak;
		}
	}
	
	static int N, M, min;
	static int[] dy = { 1, 0, -1, 0 }, dx = { 0, -1, 0, 1 };
	static char[][] map;
	
	private static int bfs() {
		Queue<Position> queue = new LinkedList<>();
		int[][][] visited = new int[N][M][2];
		queue.offer(new Position(0, 0, 0));
		visited[0][0][0] = 1;
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			if (cur.x == M - 1 && cur.y == N - 1) return visited[cur.y][cur.x][cur.isBreak];
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx][cur.isBreak] > 0) continue;
				
				if (map[ny][nx] == '0') {
					visited[ny][nx][cur.isBreak] = visited[cur.y][cur.x][cur.isBreak] + 1;
					queue.offer(new Position(nx, ny, cur.isBreak));
				} else if (cur.isBreak == 0) {
					visited[ny][nx][1] = visited[cur.y][cur.x][cur.isBreak] + 1;
					queue.offer(new Position(nx, ny, 1));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.println(bfs());
		
		br.close();
	}

}
