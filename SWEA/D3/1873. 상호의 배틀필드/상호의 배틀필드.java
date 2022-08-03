import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1873. 상호의 배틀필드
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
public class Solution {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] board = new char[H][W];
			int x = 0;
			int y = 0;

			int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			int d = 0;

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = s.charAt(j);
					board[i][j] = c;
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						x = i;
						y = j;
						if (c == '^')
							d = 0;
						else if (c == 'v')
							d = 1;
						else if (c == '<')
							d = 2;
						else
							d = 3;
					}

				}
			}

			int N = Integer.parseInt(br.readLine());
			char[] s = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (s[i] == 'S') { // 'S', 현재 방향으로 포탄 발사
					int nx = x;
					int ny = y;
					while (true) {
						nx += dir[d][0];
						ny += dir[d][1];
						if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
							if (board[nx][ny] == '*') {
								board[nx][ny] = '.';
								break;
							} else if (board[nx][ny] == '#')
								break;
						} else
							break;
					}
				} else {
					if (s[i] == 'U') {
						d = 0;
						board[x][y] = '^';
					} else if (s[i] == 'D') {
						d = 1;
						board[x][y] = 'v';
					} else if (s[i] == 'L') {
						d = 2;
						board[x][y] = '<';
					} else if (s[i] == 'R') {
						d = 3;
						board[x][y] = '>';
					}
					
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] == '.') {
						board[x][y] = '.';
						x = nx;
						y = ny;
						if (s[i] == 'U')
							board[x][y] = '^';
						else if (s[i] == 'D')
							board[x][y] = 'v';
						else if (s[i] == 'L')
							board[x][y] = '<';
						else if (s[i] == 'R')
							board[x][y] = '>';

					}
				}
			}

			sb.append("#");
			sb.append(t);
			sb.append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}

}
