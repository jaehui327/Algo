import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5215. 햄버거 다이어트
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
public class Solution {

	static int N, L, max;
	static int[] taste, calorie;
	static boolean[] visited;

	private static void subset(int idx, int score, int cal) {
		if (cal > L) return;
		if (idx == N) {
			max = Math.max(max, score);
			return;
		}
		visited[idx] = true;
		subset(idx + 1, score + taste[idx], cal + calorie[idx]);
		visited[idx] = false;
		subset(idx + 1, score, cal);
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input/5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = 0;
			taste = new int[N];
			calorie = new int[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st2.nextToken());
				calorie[i] = Integer.parseInt(st2.nextToken());
			}

			subset(0, 0, 0);

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
