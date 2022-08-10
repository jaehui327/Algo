import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dp = new int[30][30];
	
	static int bridge(int n, int r) {
		if (dp[n][r] > 0) return dp[n][r];
		if (r == 0 || n == r) return dp[n][r] = 1;
		return dp[n][r] = bridge(n - 1, r - 1) + bridge(n - 1, r);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(M, N)).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}
