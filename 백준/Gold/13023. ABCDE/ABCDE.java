import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE
// https://www.acmicpc.net/problem/13023
public class Main {

	static int N, M;
	static boolean[] visited;
	static List<List<Integer>> map;

	private static void dfs(int v, int level) {
		if (level == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		for (int i = 0; i < map.get(v).size(); i++) {
			int x = map.get(v).get(i);
			if (!visited[x]) {
				visited[x] = true;
				dfs(x, level + 1);
				visited[x] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList<List<Integer>>();

		for (int i = 0; i < N; i++) {
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, 0);
		}

		System.out.println(0);
		br.close();
	}
}
