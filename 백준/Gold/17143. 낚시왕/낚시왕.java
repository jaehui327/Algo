import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int R, C, M, sum;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] board;
	static List<Shark> shark;

	private static void fishing(int c) {
		int r = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < shark.size(); i++) {
			if (c == shark.get(i).c && r > shark.get(i).r) {
				r = shark.get(i).r;
				idx = i;
			}
		}
		if (idx >= 0) {
			sum += shark.get(idx).z;
			shark.remove(idx);
		}
	}

	private static void move() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(board[i], 0);
		}

		for (int i = 0; i < shark.size(); i++) {
			Shark s = shark.get(i);
			int nr = s.r;
			int nc = s.c;
			int nd = s.d;
			
			for (int j = 0; j < s.s; j++) {
				if (nr + dr[nd] < 0 || nr + dr[nd] >= R || nc + dc[nd] < 0 || nc + dc[nd] >= C)
					nd = (nd + 2) % 4;
				nr += dr[nd];
				nc += dc[nd];
			}
			s.r = nr;
			s.c = nc;
			s.d = nd;

			if (board[nr][nc] < s.z) {
				board[nr][nc] = s.z;
			}
		}

		for (int i = shark.size() - 1; i >= 0; i--) {
			if (board[shark.get(i).r][shark.get(i).c] > shark.get(i).z) {
				shark.remove(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		shark = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			if (d < 2) { // 상하
				s = s % ((R - 1) * 2);
			} else { // 좌우
				s = s % ((C - 1) * 2);
			}
            
            if (d == 1)
				d = 2;
			else if (d == 2)
				d = 1;
            
			shark.add(new Shark(r, c, s, d, z));
		}

		for (int c = 0; c < C; c++) {
			fishing(c);
			move();
		}

		br.close();
		System.out.println(sum);
	}

}
