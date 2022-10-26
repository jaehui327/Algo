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
	
	static int R, C, blockCount;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static char[] blocks = { '|', '-', '1', '2', '3', '4', '+' };
	static int[][] dir = {
			{ 1, 3 },
			{ 0, 2 },
			{ 0, 3 },
			{ 0, 1 }, 
			{ 1, 2 },
			{ 2, 3 },
			{ 0, 1, 2, 3 }
	};
	static char[][] board;
	
	private static Position pipe() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '.') {
					for (int b = 0; b < blocks.length; b++) {
						board[i][j] = blocks[b];
						if (isAvailable(j, i)) {
							return new Position(j, i);
						}
					}
					board[i][j] = '.';
				}
			}
		}
		return null;
	}
	
	private static boolean isAvailable(int x, int y) {
		int count = bfs(x, y);
		
		if (count == blockCount)
			return true;
		else
			return false;
	}
	
	private static int bfs(int x, int y) {
		int count = 0;
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		
		queue.add(new Position(x, y));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			int[] dd = dir[getDirection(cur.x, cur.y)];
			for (int d = 0; d < dd.length; d++) {
				int nx = cur.x + dx[dd[d]];
				int ny = cur.y + dy[dd[d]];
				
				if (nx < 0 || nx >= C || ny < 0 || ny >= R || board[ny][nx] == '.') return 0;
				if (board[ny][nx] == 'M' || board[ny][nx] == 'Z') continue;
				
				int[] nd = dir[getDirection(nx, ny)];
				boolean flag = false;
				for (int i = 0; i < nd.length; i++) {
					if ((dd[d] + 2) % 4 == nd[i]) {
						flag = true;
					}
				}
				if (!flag) return 0;
				
				if (visited[ny][nx]) continue;
				flag = false;
				for (int i = 0; i < nd.length; i++) {
					if ((dd[d] + 2) % 4 == nd[i]) {
						count += 1;
						queue.add(new Position(nx, ny));
						visited[ny][nx] = true;
						flag = true;
						break;
					}
				}
				if (!flag) return 0;
			}
		}
		
		return count;
	}
	
	private static int getDirection(int x, int y) {
		for (int i = 0; i < blocks.length; i++) {
			if (board[y][x] == blocks[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] != 'M' && board[i][j] != 'Z' && board[i][j] != '.')
					blockCount += 1;
			}
		}
		
		Position p = pipe();
		System.out.printf("%d %d %c \n", p.y + 1, p.x + 1, board[p.y][p.x]);
		
		br.close();
	}

}
