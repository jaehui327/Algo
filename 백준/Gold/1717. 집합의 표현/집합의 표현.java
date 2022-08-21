import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] parent;
	
	private static int findParent(int a) {
		if (a == parent[a]) return a;
		return parent[a] = findParent(parent[a]);
	}
	
	private static boolean isSameParent(int a, int b) {
		if (findParent(a) == findParent(b)) return true;
		else return false;
	}
	
	private static void setUnion(int p, int c) {
		parent[findParent(c)] = findParent(p);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			if (Integer.parseInt(s.nextToken()) == 0) {
				setUnion(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
			} else {
				if (isSameParent(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()))) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		br.close();
		System.out.println(sb);
	}
}
