import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	static boolean[] selected;
	static int[][] board;
	
	private static void startLink(int idx, int start) {
		if (idx == N / 2) {
			get_power();
			return;
		}
		for (int i = start; i < N; i++) {
			selected[i] = true;
			startLink(idx + 1, i + 1);
			selected[i] = false;
		}
	}
	
	private static void get_power() {
		int S = 0, L = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] && selected[j] && i != j) 
					S += board[i][j] + board[j][i];
				else if (!selected[i] && !selected[j] && i != j)
					L += board[i][j] + board[j][i];
			}
		}
		min = Math.min(min, Math.abs(S - L));
	}
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		selected = new boolean[N];
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startLink(0, 0);
		
		sb.append(min);
		br.close();
		System.out.println(sb);
	}
}
