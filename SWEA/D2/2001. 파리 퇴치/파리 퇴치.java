import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2001. 파리퇴치
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
public class Solution {
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer input = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(input.nextToken());
			int M = Integer.parseInt(input.nextToken());
			
			int[][] dp = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				StringTokenizer b = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					dp[i][j] =  Integer.parseInt(b.nextToken()) + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
				}
			}
			
			int temp = 0;
			int max = 0;
			for(int i=M; i<=N; i++) {
				for(int j=M; j<=N; j++) {
					temp = dp[i][j] - dp[i-M][j] - dp[i][j-M] + dp[i-M][j-M];
					max = Math.max(max, temp);
				}
			}

			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(max);
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

}