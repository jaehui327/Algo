import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, min = Integer.MAX_VALUE;
	static int[][] board;
	static int[][] operation;
	static int[] selected;
	static boolean[] visited;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static void permutation(int idx) {
		if (idx == K) {
			int[][] copy = new int[N + 1][M + 1];
			for(int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					copy[i][j] = board[i][j];
				}
			}
			rotate(copy, selected);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			selected[idx] = i;
			visited[i] = true;
			permutation(idx + 1);
			visited[i] = false;
		}
	}
	
	private static void rotate(int[][] board, int[] selected) {
		int R, C, S;
		for(int k = 0; k < K; k++) {
			R = operation[selected[k]][0]; 
			C = operation[selected[k]][1];
			S = operation[selected[k]][2];
					for (int i = 0; i < S; i++) {
						int start = board[R - S + i][C - S + i];
						int r = R - S + i;
						int c = C - S + i;
						int d = 0;
						while (d < 4) {
							int nr = r + dir[d][0];
							int nc = c + dir[d][1];
							
							if (nr >= R - S + i && nr <= R + S - i && nc >= C - S + i && nc <= C + S - i) {
								board[r][c] = board[nr][nc];
								r = nr;
								c = nc;
							} else d++;
						}
						board[R - S + i][C - S + i + 1] = start;
					}
		}
		findMin(board);
	}
	
	private static void findMin(int[][] board) {
		for (int i = 1; i < N + 1; i++) {
			int temp = 0;
			for (int j = 1; j < M + 1; j++) {
				temp += board[i][j];
			}
			min = Math.min(min, temp);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		operation = new int[K][3];
		selected = new int[K];
		visited = new boolean[K];

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			operation[k][0] = Integer.parseInt(st2.nextToken());
			operation[k][1] = Integer.parseInt(st2.nextToken());
			operation[k][2] = Integer.parseInt(st2.nextToken());
		}
		
		permutation(0);
		
		sb.append(min);

		br.close();
		System.out.println(sb);
	}
}
