import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 무선 충전
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
public class Solution {

	static int N = 10, M, A, max;
	static int[] userA, userB, dx = {0, 0, 1, 0, -1}, dy = {0, -1, 0, 1, 0};
	static int[][] bc;
	
	private static void wirelessCharging() {
		int ay = 1, ax = 1;
		int by = N , bx = N;
		charge(ay, ax, by, bx);
		for (int i = 0; i < M; i++) {
			ay += dy[userA[i]];
			ax += dx[userA[i]];
			by += dy[userB[i]];
			bx += dx[userB[i]];
			charge(ay, ax, by, bx);
		}
	}
	
	private static void charge(int ay, int ax, int by, int bx) {
		List<int[]> a = new LinkedList<>(), b = new LinkedList<>();
		for (int i = 0; i < A; i++) {
			int x = bc[i][0];
			int y = bc[i][1];
			if (bc[i][2] >= (Math.abs(ax - x) + Math.abs(ay - y))) a.add(new int[] {i, bc[i][3]});
			if (bc[i][2] >= (Math.abs(bx - x) + Math.abs(by - y))) b.add(new int[] {i, bc[i][3]});
		}
		if (a.isEmpty() && b.isEmpty()) return;
		else if(!a.isEmpty() && b.isEmpty()) max += a.get(0)[1];
		else if(a.isEmpty() && !b.isEmpty()) max += b.get(0)[1];
		else {
			int temp = 0;
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < b.size(); j++) {
					if (a.get(i)[0] != b.get(j)[0])
						temp = Math.max(temp, a.get(i)[1] + b.get(j)[1]);
					else
						temp = Math.max(temp, a.get(i)[1]);
				}
			}
			max += temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			userA = new int[M];
			userB = new int[M];
			bc = new int[A][4];
			StringTokenizer a = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userA[i] = Integer.parseInt(a.nextToken());
			}
			StringTokenizer b = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userB[i] = Integer.parseInt(b.nextToken());
			}

			for (int i = 0; i < A; i++) {
				StringTokenizer p = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(p.nextToken());
				}
			}
			Arrays.sort(bc, (o1, o2) -> o2[3] - o1[3]);

			wirelessCharging();
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
