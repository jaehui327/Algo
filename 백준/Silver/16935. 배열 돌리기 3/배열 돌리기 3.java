import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16935. 배열 돌리기 3
// https://www.acmicpc.net/problem/16935
public class Main {

	static int N, M, R;
	static int[][] board;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[100][100];

		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
			}
		}

		StringTokenizer operation = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int o = Integer.parseInt(operation.nextToken());
			switch (o) {
			case 1:
				up_down_reverse();
				break;
			case 2:
				left_right_reverse();
				break;
			case 3:
				rotate_right_90();
				break;
			case 4:
				rotate_left_90();
				break;
			case 5:
				rotate_right_quarter();
				break;
			default:
				rotate_left_quarter();
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static void up_down_reverse() {
		for (int i = 0; i < N / 2; i++) {
			int[] temp = board[i];
			board[i] = board[N - 1 - i];
			board[N - 1 - i] = temp;
		}
	}

	private static void left_right_reverse() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = board[i][j];
				board[i][j] = board[i][M - 1 - j];
				board[i][M - 1 - j] = temp;
			}
		}
	}

	private static void rotate_right_90() {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotate[j][N - 1 - i] = board[i][j];
			}
		}
		board = rotate;
		int temp = N;
		N = M;
		M = temp;
	}

	private static void rotate_left_90() {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotate[M - 1 - j][i] = board[i][j];
			}
		}
		board = rotate;
		int temp = N;
		N = M;
		M = temp;
	}

	private static void rotate_right_quarter() {
		int[][] rotate = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotate[i][j + M / 2] = board[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				rotate[i + N / 2][j] = board[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				rotate[i][j - M / 2] = board[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotate[i - N / 2][j] = board[i][j];
			}
		}
		board = rotate;
	}

	private static void rotate_left_quarter() {
		int[][] rotate = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotate[i + N / 2][j] = board[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotate[i][j + M / 2] = board[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				rotate[i - N / 2][j] = board[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				rotate[i][j - M / 2] = board[i][j];
			}
		}
		
		board = rotate;
	}
}
