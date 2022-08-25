import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	static int[][] board;
	
	private static void travelingSalesman(int idx, int visited, int cost) {
		if (visited == (1 << N) - 1) {
			if (board[idx][0] > 0) min = Math.min(min, cost + board[idx][0]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0 || board[idx][i] == 0 || cost + board[idx][i] > min) continue;
			travelingSalesman(i, visited | 1 << i, cost + board[idx][i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		travelingSalesman(0, 1 << 0, 0);
		sb.append(min);

		br.close();
		System.out.println(sb);
	}
	
}
