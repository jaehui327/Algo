import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 감시
// https://www.acmicpc.net/problem/15683
public class Main {

	static int N, M, min;
	static int[] dir, dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 }; // 좌상우하
	static List<int[]> cctv;
	static int[][] board;

	private static void surveillance(int n) {
		if (n == cctv.size()) {
			bfs();
			return;
		}

		switch (cctv.get(n)[0]) {
		case 1: case 3: case 4:
			for (int i = 0; i < 4; i++) {
				dir[n] = i;
				surveillance(n + 1);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				dir[n] = i;
				surveillance(n + 1);
			}
			break;
		case 5:
			dir[n] = 0;
			surveillance(n + 1);
			break;
		default:
			break;
		}
	}

	private static void bfs() {
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < cctv.size(); i++) {
			switch (cctv.get(i)[0]) {
			case 1:
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i]);
				break;
			case 2:
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i]);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 2);
				break;
			case 3:
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i]);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 1);
				break;
			case 4:
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i]);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 1);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 2);
				break;
			case 5:
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i]);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 1);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 2);
				map = move(map, cctv.get(i)[1], cctv.get(i)[2], dir[i] + 3);
				break;
			default:
				break;
			}
		}
		FindBlindSpot(map);
	}

	private static int[][] move(int[][] board, int x, int y, int d) {
		while (true) {
			x += dx[d % 4];
			y += dy[d % 4];
			if (x < 0 || x >= M || y < 0 || y >= N || board[y][x] == 6) break;
			else if (board[y][x] == 0) board[y][x] = -1;
		}
		return board;
	}
	
	private static void FindBlindSpot(int[][] board) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) temp++;
			}
		}
		min = Math.min(min, temp);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		board = new int[N][M];
		cctv = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
				if (board[i][j] > 0 && board[i][j] < 6)
					cctv.add(new int[] { board[i][j], j, i });
			}
		}
		dir = new int[cctv.size()];

		surveillance(0);
		sb.append(min);
		br.close();
		System.out.println(sb);
	}
}
