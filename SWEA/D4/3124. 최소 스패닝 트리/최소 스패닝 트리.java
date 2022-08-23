import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
class Edge {
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class Solution {
	
	static int[] parent;
	
	private static long kruskal(PriorityQueue<Edge> edges) {
		long result = 0;
		while(!edges.isEmpty()) {
			Edge e = edges.poll();
			if (!isSameParent(e.from, e.to)) {
				union(e.from, e.to);
				result += e.weight;
			}
		}
		return result;
	}

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
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parent = new int[V + 1];
			PriorityQueue<Edge> edges = new PriorityQueue<>((x, y) -> x.weight - y.weight);
			
			for (int i = 0; i < V; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < E; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				int weight = Integer.parseInt(s.nextToken());
				edges.add(new Edge(a, b, weight));
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(kruskal(edges));
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
