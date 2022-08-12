import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static int[][] board, selected, dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<int[]> house, chiken;

	private static void chiken_distance(int idx, int start) {
		if (idx == M) {
			get_distance();
			return;
		}
		for (int i = start; i < chiken.size(); i++) {
			selected[idx] = chiken.get(i);
			chiken_distance(idx + 1, i + 1);
		}
	}

	private static void get_distance() {
		int[][] board = new int[N + 1][N + 1];
		int temp = 0;
		for (int i = 0; i < selected.length; i++) {
			board[selected[i][0]][selected[i][1]] = 2;
		}
		for (int i = 0; i < house.size(); i++) {
			int[][] visited = new int[N + 1][N + 1];
			Queue<int[]> queue = new LinkedList<>();
			int[] t = house.get(i);
			visited[t[0]][t[1]] = 1;
			queue.offer(new int[] {t[0], t[1]});
			outer:while(!queue.isEmpty()) {
				int[] h = queue.poll();
				int r = h[0];
				int c = h[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
					if (nr > 0 && nr <= N && nc > 0 && nc <= N && visited[nr][nc] == 0) {
						visited[nr][nc] = visited[r][c] + 1;
						if (board[nr][nc] == 2) {
							temp += visited[r][c];
							break outer;
						} else queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
		min = Math.min(min, temp);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		min = Integer.MAX_VALUE;
		board = new int[N + 1][N + 1];
		selected = new int[M][2];
		house = new ArrayList<>();
		chiken = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					house.add(new int[] { i, j });
				else if (board[i][j] == 2)
					chiken.add(new int[] { i, j });
			}
		}

		chiken_distance(0, 0);
		sb.append(min);

		br.close();
		System.out.println(sb);
	}
}
