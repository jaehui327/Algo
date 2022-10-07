import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, cnt;
	static int[][] bigger, lower;
	
	private static int heightOrder() {
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			count(i, bigger, new boolean[N + 1]);
			count(i, lower, new boolean[N + 1]);
			if (cnt == N - 1)
				answer += 1;
		}
		
		return answer;
	}

	private static void count(int node, int[][] board, boolean[] visited) {
		visited[node] = true;
		for (int i = 1; i <= N; i++) {
			if (board[node][i] == 0 || visited[i]) continue;
			count(i, board, visited);
			cnt += 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			bigger = new int[N + 1][N + 1];
			lower = new int[N + 1][N + 1];
			
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bigger[a][b] = 1;
				lower[b][a] = 1;
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(heightOrder()).append("\n");
		}
		
		br.close();
		System.out.println(sb.toString());
	}

}
