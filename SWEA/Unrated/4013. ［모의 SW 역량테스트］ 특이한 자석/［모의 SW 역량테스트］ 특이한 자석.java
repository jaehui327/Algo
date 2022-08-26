import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 특이한 자석
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
public class Solution {

	static int M = 4, N = 8;
	static LinkedList[] magnet;

	private static void dfs(int i, int d, int visited) {
		if (i - 1 >= 0 && (visited & (1 << i - 1)) == 0 && magnet[i - 1].get(2) != magnet[i].get(N - 2)) dfs(i - 1, d * (-1), visited | (1 << i - 1));
		if (i + 1 < M && (visited & (1 << i + 1)) == 0 && magnet[i].get(2) != magnet[i + 1].get(N - 2)) dfs(i + 1, d * (-1), visited | (1 << i + 1));
		
		if(d == 1) magnet[i].addFirst(magnet[i].pollLast());
		else magnet[i].addLast(magnet[i].pollFirst());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			
			magnet = new LinkedList[N];
			for (int i = 0; i < M; i++) {
				magnet[i] = new LinkedList<Integer>();
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					magnet[i].addLast(Integer.parseInt(s.nextToken()));
				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(s.nextToken());
				int d = Integer.parseInt(s.nextToken());
				dfs(num - 1, d, 1 << (num - 1));
			}

			int answer = 0;
			for (int i = 0; i < M; i++) {
				if ((int)magnet[i].get(0) == 1)
					answer += Math.pow(2, i);
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
