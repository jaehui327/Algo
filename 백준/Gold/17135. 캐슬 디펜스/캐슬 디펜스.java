import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, max;
	static int[] archer;
	static List<int[]> enemy;

	private static void defense(int idx, int start) {
		if (idx == 3) {
			List<int[]> list  = new LinkedList<>();
			for (int i = 0; i < enemy.size(); i++) {
				list.add(enemy.get(i));
			}
			attack(list);
			return;
		}
		// 막혔던 부분 2 : N이 아니라 M 46퍼 에러
		for (int i = start; i < M; i++) {
			archer[idx] = i;
			defense(idx + 1, i + 1);
		}
	}

	private static void attack(List<int[]> enemy) {
		int kill = 0;
		while (!enemy.isEmpty()) {
			int[][] pos = new int[3][2];
			for (int i = 0; i < archer.length; i++) {
				int y = N;
				int x = archer[i];
				pos[i] = findNearEnemy(x, y, enemy);
			}
			
			for (int i = 0; i < pos.length; i++) {
				for (int j = enemy.size() - 1; j > -1; j--) {
					if (enemy.get(j)[0] == pos[i][0] && enemy.get(j)[1] == pos[i][1]) {
						enemy.remove(j);
						kill++;
						break;
					}
				}
			}
			
			
			// 이동
			for (int i = enemy.size() - 1; i > -1; i--) {
				if (enemy.get(i)[1] + 1 == N) enemy.remove(i);
				else enemy.set(i, new int[] {enemy.get(i)[0], enemy.get(i)[1] + 1});
			}
			
			
		}
		
		
		max = Math.max(max, kill);
	}
	
	private static int[] findNearEnemy(int ax, int ay, List<int[]> enemy) {
		int x = -1, y = -1, d = 999999;
		for (int i = 0; i < enemy.size(); i++) {
			int ex = enemy.get(i)[0];
			int ey = enemy.get(i)[1];
			int dist = manhattanDist(ax, ay, ex, ey);
			
			// 막혔던 부분1 : 왼쪽부터 쏜다
			if (dist <= D && (dist < d || (dist == d && x > ex))) {
				d = dist;
				x = ex;
				y = ey;
			}
		}
		
		return new int[] {x, y};
	}

	private static int manhattanDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = 0;

		archer = new int[3];
		enemy = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < M; x++) {
				if (Integer.parseInt(s.nextToken()) == 1)
					enemy.add(new int[] { x, y });
			}
		}

		defense(0, 0);
		sb.append(max);

		br.close();
		System.out.println(sb);
	}
}
