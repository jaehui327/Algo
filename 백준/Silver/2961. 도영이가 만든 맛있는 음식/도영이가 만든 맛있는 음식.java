import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2961. 도영이가 만든 맛있는 음식
// https://www.acmicpc.net/problem/2961
public class Main {

	static int N, min;
	static int[] S, B;
	
	private static void subset(int idx, int s, int b, int flag) {
		if (idx == N) {
			if (flag != 0) min = Math.min(min, Math.abs(s - b));
			return;
		}
		if ((flag & 1 << idx) != 0) return;
		subset(idx + 1, s * S[idx], b + B[idx], flag | 1 << idx);
		subset(idx + 1, s, b, flag);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 1, 0, 0);
		sb.append(min);
		br.close();
		System.out.println(sb);
	}
}
