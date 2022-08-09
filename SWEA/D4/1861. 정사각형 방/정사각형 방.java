import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

// 1861. 정사각형 방
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
public class Solution {

	static int N, r_num, r_max;
	static int[][] board;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	static int square(int r, int c, int n) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == board[r][c] + 1 && !visited[r][c]) {
				visited[r][c] = true;
				n = square(nr, nc, n + 1);
				visited[r][c] = false;
				if(n > r_max) {
					r_max = n;
					r_num = board[r][c];
				} else if(n == r_max && board[r][c] < r_num) {
					r_num = board[r][c];
				}
			}
		}
		return n;
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input/1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			r_num = Integer.MAX_VALUE;
			r_max = 0;
			board = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					square(i, j, 1);
				}
			}

			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(r_num);
			sb.append(" ");
			sb.append(r_max);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
