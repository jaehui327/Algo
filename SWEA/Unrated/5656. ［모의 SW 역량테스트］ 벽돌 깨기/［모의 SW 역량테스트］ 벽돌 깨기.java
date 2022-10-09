import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H, min;
	static int[] selected, dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static int[][] board;

	private static void repeatPermutation(int idx) {
		if (idx == N) {
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = board[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				findBrick(map, selected[i]);
			}

			min = Math.min(min, getBrickCnt(map));
			return;
		}
		for (int i = 0; i < W; i++) {
			selected[idx] = i;
			repeatPermutation(idx + 1);
		}
	}

	private static void findBrick(int[][] board, int x) {
		for (int y = 0; y < H; y++) {
			if (board[y][x] != 0) {
				breaking(x, y, board[y][x], board);
				pushDown(board);
				break;
			}
		}
	}

	private static void breaking(int x, int y, int n, int[][] board) {
		board[y][x] = 0;
		if (n <= 1) return;

		for (int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			for (int i = 0; i < n - 1; i++) {
				nx += dx[d];
				ny += dy[d];
				if (nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
				if (board[ny][nx] != 0) {
					breaking(nx, ny, board[ny][nx], board);
				}
			}
		}
	}

	private static void pushDown(int[][] board) {
		for (int x = 0; x < W; x++) {
			Deque<Integer> deque = new ArrayDeque<Integer>();
			for (int y = 0; y < H; y++) {
				if (board[y][x] == 0) continue;
				deque.addFirst(board[y][x]);
				board[y][x] = 0;
			}
			int y = H - 1;
			while(!deque.isEmpty()) {
				board[y][x] = deque.pollFirst();
				y -= 1;
			}
		}
	}

	private static int getBrickCnt(int[][] board) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] == 0)
					continue;
				cnt += 1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			selected = new int[N];
			board = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			repeatPermutation(0);

			sb.append("#").append(t).append(" ");
			sb.append(min).append("\n");
		}

		br.close();
		System.out.println(sb.toString());
	}
}
