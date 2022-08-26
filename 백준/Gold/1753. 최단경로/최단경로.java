import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
// https://www.acmicpc.net/problem/1753
public class Main {

	static class Edge {
		int vertex;
		int weight;
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int V, E;
	static int[] dp;
	static Map<Integer, List<Edge>> map;
	
	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x, y) -> x.weight - y.weight);
		dp = new int[V + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		pq.add(new Edge(start, 0));
		dp[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (dp[e.vertex] < e.weight) continue;
			
			List<Edge> edges = map.get(e.vertex);
			for (Edge ne : edges) {
				int nw = e.weight + ne.weight;
				if (dp[ne.vertex] > nw) {
					dp[ne.vertex] = nw;
					pq.add(new Edge(ne.vertex, nw));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		map = new HashMap<Integer, List<Edge>>();
		for (int i = 1; i <= V; i++) {
			map.put(i, new ArrayList<Edge>());
		}
		
		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(s.nextToken());
			int v = Integer.parseInt(s.nextToken());
			int w = Integer.parseInt(s.nextToken());
			map.get(u).add(new Edge(v, w));
		}
		
		dijkstra(start);
		for (int i = 1; i <= V; i++) {
			if (dp[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dp[i]).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}
