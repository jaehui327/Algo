import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Position {
		int key;
		int x;
		int y;
		int c;
		
		Position(int key, int x, int y, int c) {
			this.key = key;
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	static int N, M, cnt;
	static int[] dx = { 1, 0, -1, 0}, dy = { 0, -1, 0, 1 };
	static char[][] board;
	static boolean[][][] visited;
	
	private static void bfs(Position start) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			visited[cur.key][cur.y][cur.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int nkey = cur.key;
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || board[ny][nx] == '#' || visited[nkey][ny][nx]) continue;
				if (board[ny][nx] == '1') { // 도착지
					cnt = cur.c + 1;
					return;
				}
				if (Character.isUpperCase(board[ny][nx])) { // 문
					if ((nkey & (1 << (board[ny][nx] - 'A'))) == 0) continue;
				}
				
				if (Character.isLowerCase(board[ny][nx])) { // 열쇠
					visited[nkey][ny][nx] = true;
					nkey = nkey | (1 << (board[ny][nx] - 'a'));
				}
				
				visited[nkey][ny][nx] = true;
				queue.offer(new Position(nkey, nx, ny, cur.c + 1));
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = -1;

		board = new char[N][M];
		visited = new boolean[1 << 7][N][M];
		
		Position start = null;
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == '0')
					start = new Position(0, j, i, 0);
			}
		}
		bfs(start);
		
		br.close();
		System.out.println(cnt);
	}
}
