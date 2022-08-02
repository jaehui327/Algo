import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] board;
	static int[][] visited;

	static int[] dx = { -1, 1 };

	static int search(int i, int j) {
		visited = new int[100][100];
		visited[i][j] = 1;
		while (true) {
			if (i == 0) return j;

//			int j_right = j + 1;
//			int j_left = j - 1;
//			int i_up = i - 1;
//
//			if (j_right < 100 && board[i][j_right] == 1 && visited[i][j_right] == 0) {
//				visited[i][j_right] = 1;
//				j = j_right;
//
//			} else if (j_left >= 0 && board[i][j_left] == 1 && visited[i][j_left] == 0) {
//				visited[i][j_left] = 1;
//				j = j_left;
//			} else if (i_up >= 0 && board[i_up][j] == 1 && visited[i_up][j] == 0) {
//				visited[i_up][j] = 1;
//				i = i_up;
//			}

			for (int d = 0; d < 2; d++) {
				while(true) {
					int nx = j + dx[d];
					if (nx < 0 || nx >= 100) break;
					if (board[i][nx] == 0 || visited[i][nx] == 1) break;
					visited[i][nx] = 1;
					j=nx;
				}
			}
			i--;
		}

	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int x = 0;

			board = new int[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer b = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(b.nextToken());
				}
			}

			for (int j = 99; j >= 0; j--) {
				if (board[99][j] == 2) {
					x = search(99, j);
					break;
				}
			}

			sb.append("#");
			sb.append(T);
			sb.append(" ");
			sb.append(x);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}
