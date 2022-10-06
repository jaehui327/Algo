import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Cell {
		int r;
		int c;
		int x; // 생명력 
		int t; // 남은 시간 
		
		Cell(int r, int c, int x, int t) {
			this.r = r;
			this.c = c;
			this.x = x;
			this.t = t;
		}
	}
	
	static int N, M, K;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] visited;
	static Queue<Cell> inactiveCells;
	static Queue<Cell> activeCells;
	
	private static void reproduction() {
		checkInactionCells();
		bfs();
	}
	
	private static void checkInactionCells() {
		int size = inactiveCells.size();
		for (int i = 0; i < size; i++) {
			Cell cell = inactiveCells.poll();
			if (cell.t == 0) {
				cell.t = cell.x;
				activeCells.offer(cell);
			}
			else {
				cell.t -= 1;
				inactiveCells.offer(cell);
			}
		}
	}
	
	private static void bfs() {
		Queue<Cell> queue = new LinkedList<>();
		
		int size = activeCells.size();
		for (int i = 0; i < size; i++) {
			Cell cur = activeCells.poll();
			if (cur.t - 1 > 0) {
				activeCells.offer(new Cell(cur.r, cur.c, cur.x, cur.t - 1));
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (!visited[nr][nc]) {
					board[nr][nc] = cur.x;
					queue.offer(new Cell(nr, nc, cur.x, cur.x));
				}
			}
		}
		
		size = queue.size();
		for (int i = 0; i < size; i++) {
			Cell cell = queue.poll();
			if (!visited[cell.r][cell.c] && board[cell.r][cell.c] < cell.x)
				board[cell.r][cell.c] = cell.x;
			queue.offer(cell);
		}
		
		for (int i = 0; i < size; i++) {
			Cell cell = queue.poll();
			if (!visited[cell.r][cell.c] && board[cell.r][cell.c] == cell.x) {
				visited[cell.r][cell.c] = true;				
				inactiveCells.offer(cell);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[350][350];
			visited = new boolean[350][350];
			inactiveCells = new LinkedList<>();
			activeCells = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int x = Integer.parseInt(st.nextToken());
					board[150 + i][150 + j] = x;
					if (x != 0) {
						visited[150 + i][150 + j] = true;
						inactiveCells.offer(new Cell(150 + i, 150 + j, x, x));
					}
				}
			}
			
			for (int k = 0; k < K; k++) {
				reproduction();
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(inactiveCells.size() + activeCells.size()).append("\n");
		}
		
		br.close();
		System.out.println(sb.toString());
	}

}
