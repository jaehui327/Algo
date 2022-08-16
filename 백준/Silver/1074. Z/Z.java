import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z
// https://www.acmicpc.net/problem/1074
public class Main {

	static int Z(int N, int r, int c) {
		int half = 1 << (N - 1);
		if (N == 0) {
			return 0;
		}
		if (r < half && c < half) {
			return Z(N - 1, r, c);
		} else if (r < half && c >= half) {
			return half * half + Z(N - 1, r, c - half);
		} else if (r >= half && c < half) {
			return 2 * half * half + Z(N - 1, r - half, c);
		} else {
			return 3 * half * half + Z(N - 1, r - half, c - half);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		sb.append(Z(N, r, c));

		br.close();
		System.out.println(sb);
	}
}
