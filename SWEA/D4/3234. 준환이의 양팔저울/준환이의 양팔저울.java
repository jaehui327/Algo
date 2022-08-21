import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준환이의 양팔저울
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
public class Solution {

	static StringBuilder sb;
	static int N, result;
	static int[] weight, selected;
	
	private static void permutation(int idx, int visited) {
		if (idx == N) {
			scales(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0) continue;
			selected[idx] = weight[i];
			permutation(idx + 1, visited | 1 << i);
		}
	}
	
	private static void scales(int idx, int r, int l) {
		if (idx == N) {
			result++;
			return;
		}
		if (r + selected[idx] <= l) scales(idx + 1, r + selected[idx], l);
		if (r <= l + selected[idx]) scales(idx + 1, r, l + selected[idx]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			weight = new int[N];
			selected = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, 0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}
