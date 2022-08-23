import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
			
			sb.append("#").append(t).append(" ");
			
			for (int i = 0; i < M; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(s.nextToken());
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				if (command == 0) { // 합집합
					union(a, b);
				} else { // 같은 집합에 포함되어 있는지 확인 - 포함이면 1, 아니면 0
					if (isSameParent(a, b)) sb.append(1);
					else sb.append(0);
				}
			}
			
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
