import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11660. 구간 합 구하기 5
// https://www.acmicpc.net/problem/11660

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		
		int[][] board = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer b = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				board[i][j] = Integer.parseInt(b.nextToken());
				dp[i][j] += dp[i][j-1] + board[i][j];
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=2; j<=N; j++) {
				dp[j][i] += dp[j-1][i];
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer pos = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(pos.nextToken());
			int x1 = Integer.parseInt(pos.nextToken());
			int y2 = Integer.parseInt(pos.nextToken());
			int x2 = Integer.parseInt(pos.nextToken());
			sb.append(dp[y2][x2] - dp[y1-1][x2] - dp[y2][x1-1] + dp[y1-1][x1-1]);
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

}