import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최적 경로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
public class Solution {

	static int N, min, home_x, home_y;
	static int[][] clients;

	private static void optimumPath(int x, int y, int count, int visited, int sum) {
		if (count == N) {
			min = Math.min(min, sum + manhattanDist(x, y, home_x, home_y));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0) continue;
			optimumPath(clients[i][0], clients[i][1], count + 1, visited | 1 << i, sum + manhattanDist(x, y, clients[i][0], clients[i][1]));
		}
	}
	
	private static int manhattanDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			clients = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int comp_x = Integer.parseInt(st.nextToken());
			int comp_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				clients[i][0] = Integer.parseInt(st.nextToken());
				clients[i][1] = Integer.parseInt(st.nextToken());
			}

			optimumPath(comp_x, comp_y, 0, 0, 0);

			sb.append("#").append(t).append(" ").append(" ").append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
