import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Contact
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD

class Person {
	int level;
	int num;

	public Person(int level, int num) {
		this.level = level;
		this.num = num;
	}
}

public class Solution {

	static int max_num;
	static Map<Integer, List<Integer>> map;
	static boolean[] visited;

	private static void contact(int start) {
		Queue<Person> queue = new LinkedList<>();
		int max_level = 1;
		
		queue.offer(new Person(1, start));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Person p = queue.poll();
			
			if (max_level < p.level) {
				max_level = p.level;
				max_num = p.num;
			} else if (max_level == p.level) {
				max_num = Math.max(max_num, p.num);
			}
			
			if (!map.containsKey(p.num)) continue;
			for (int i = 0; i < map.get(p.num).size(); i++) {
				int x = map.get(p.num).get(i);
				if (!visited[x]) {
					queue.offer(new Person(p.level + 1, x));
					visited[x] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			max_num = 0;
			map = new HashMap<>();
			visited = new boolean[101];

			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < L / 2; i++) {
				int x = Integer.parseInt(s.nextToken());
				int y = Integer.parseInt(s.nextToken());
				if (!map.containsKey(x))
					map.put(x, new LinkedList<>());
				map.get(x).add(y);
			}

			contact(start);
			sb.append("#").append(t).append(" ").append(max_num).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
