import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 창용 마을 무리의 개수
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
public class Solution {
	
static int[] parent;
	
	private static int getParent(int a) {
		if (a == parent[a]) return a;
		return parent[a] = getParent(parent[a]);
	}
	
	private static boolean isSameParent(int a, int b) {
		if (getParent(a) == getParent(b)) return true;
		else return false;
	}
	
	private static void union(int a, int b) {
		parent[getParent(b)] = getParent(a);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];

			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			int group = N;

			for (int i = 0; i < M; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(s.nextToken());
				if (!s.hasMoreTokens()) continue;
				int b = Integer.parseInt(s.nextToken());
				
				if (!isSameParent(a, b)) {
					union(a, b);
					group--;
				}
			}

			sb.append("#").append(t).append(" ");
			sb.append(group);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
