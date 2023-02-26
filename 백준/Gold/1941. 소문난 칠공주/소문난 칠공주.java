import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N = 5, X = 7, answer;
	static int[] selected;
	static char[][] map;
	
	private static void combination(int start, int idx) {
		if (idx == X) {
			if (isSom() && isPrincess()) {
				answer += 1;
			}
			return;
		}
		for (int i = start; i < N * N; i++) {
			selected[idx] = i;
			combination(i + 1, idx + 1);
		}
	}
	
	private static boolean isSom() {
		int cnt = 0;
		for (int i = 0; i < X; i++) {
			if (map[selected[i] / N][selected[i] % N] == 'S') cnt += 1;
		}
		if (cnt >= 4) return true;
		else return false;
	}
	
	private static boolean isPrincess() {
		boolean[][] visited = new boolean[X][X];
		for (int i = 0; i < X; i++) {
			for (int j = i; j < X; j++) {
				if (i == j) visited[i][j] = true;
				else if (manhattanDistance(selected[i] % N, selected[i] / N, selected[j] % N, selected[j] / N) == 1) {
					visited[i][j] = true;
					visited[j][i] = true;
				}
			}
		}
		
		for (int k = 0; k < X; k++) {
			for (int i = 0; i < X; i++) {
				if (k == i) continue;
				for (int j = 0; j < X; j++) {
					if (k == j || i == j) continue;
					if (visited[i][k] && visited[k][j]) visited[i][j] = true; 
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < X; i++) {
			if (visited[0][i]) cnt += 1;
		}
		if (cnt == X) return true;
		else return false;
	}
	
	private static int manhattanDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = 0;
		selected = new int[X];
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		combination(0, 0);
		System.out.println(answer);
		br.close();
	}

}
