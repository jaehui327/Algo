import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1873. 상호의 배틀필드
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
public class Solution {

	static char[][] board = new char[20][20];
	static int H, W;
	static char[] s = new char[100];

	static int x = 0;
	static int y = 0;
	static int[][] dir = { { -1, 0, '^', 'U' }, { 1, 0, 'v', 'D' }, { 0, -1, '<', 'L' }, { 0, 1, '>', 'R'} };
	static int d = 0;

	static void shoot() {
		for(int i=0; i<4; i++) {
			if((char)dir[i][2]==board[x][y])
				d = i;
		}
		int nx = x, ny = y;
		while (true) {
			nx += dir[d][0];
			ny += dir[d][1];
			if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
				if (board[nx][ny] == '*') {
					board[nx][ny] = '.';
					return;
				} else if (board[nx][ny] == '#')
					return;
			} else
				return;
		}
	}

	static void move(char D) {
		for(int i=0; i<4; i++) {
			if((char)dir[i][3]==D)
				d = i;
		}
		board[x][y] = (char)dir[d][2];

		int nx = x + dir[d][0];
		int ny = y + dir[d][1];
		if (nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] == '.') {
			board[x][y] = '.';
			x = nx;
			y = ny;
			board[x][y] = (char)dir[d][2];
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = s.charAt(j);
					board[i][j] = c;
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						x = i; y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			s = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (s[i] == 'S') { // 'S', 현재 방향으로 포탄 발사
					shoot();
				} else {
					move(s[i]);
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
