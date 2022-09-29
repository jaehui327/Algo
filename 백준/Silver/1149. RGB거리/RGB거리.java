import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board, dp;
	
	private static int rgb(int N, int i) {
		if (dp[N][i] == 0) {
			if (i == 0) {
				dp[N][0] = board[N][0] + Math.min(rgb(N - 1, 1), rgb(N - 1, 2));
			} else if (i == 1) {
				dp[N][1] = board[N][1] + Math.min(rgb(N - 1, 0), rgb(N - 1, 2));
			} else {
				dp[N][2] = board[N][2] + Math.min(rgb(N - 1, 0), rgb(N - 1, 1));
			}
		}
		return dp[N][i];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		board = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = board[0][0];
		dp[0][1] = board[0][1];
		dp[0][2] = board[0][2];
		
		int min = Math.min(rgb(N - 1, 0), rgb(N - 1, 1));
		min = Math.min(min, rgb(N - 1, 2));
		
		System.out.println(min);
		
		br.close();
	}

}
