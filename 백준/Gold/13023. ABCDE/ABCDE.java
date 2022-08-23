import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// ABCDE
// https://www.acmicpc.net/problem/13023
public class Main {

	static int N, M;
	static boolean[] visited;
	static Map<Integer, List<Integer>> map;

	private static void dfs(int v, int level) {
		if (level == 5) {
			System.out.println(1);
			System.exit(0);
		}
		
		if (map.containsKey(v));
		for (int i = 0; i < map.get(v).size(); i++) {
			if (!visited[map.get(v).get(i)]) {
				visited[map.get(v).get(i)] = true;
				dfs(map.get(v).get(i), level + 1);
				visited[map.get(v).get(i)] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < M; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			if (!map.containsKey(a))
				map.put(a, new ArrayList<>());
			if (!map.containsKey(b))
				map.put(b, new ArrayList<>());
			map.get(a).add(b);
			map.get(b).add(a);
		}

		for (Integer key : map.keySet()) {
			visited = new boolean[N];
			dfs(key, 0);
		}

		System.out.println(0);
		br.close();
	}
}
