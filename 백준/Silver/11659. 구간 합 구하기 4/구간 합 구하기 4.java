import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11659. 구간 합 구하기 4
// https://www.acmicpc.net/problem/11659
public class Main {

	static int[] board = new int[100_001];
	static int[] dp = new int[100_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());

		StringTokenizer b = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			board[i] = Integer.parseInt(b.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dp[i] += dp[i - 1] + board[i];
		}

		for (int k = 0; k < M; k++) {
			StringTokenizer t = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(t.nextToken());
			int j = Integer.parseInt(t.nextToken());
			sb.append(dp[j] - dp[i - 1]);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}