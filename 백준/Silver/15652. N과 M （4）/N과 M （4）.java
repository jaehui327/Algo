import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4)
// https://www.acmicpc.net/problem/15652
public class Main {

	static StringBuilder sb;
	static int N, M;
	static int[] numbers;

	private static void combination_with_repetion(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[idx] = i;
			combination_with_repetion(idx + 1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];

		combination_with_repetion(0, 1);

		br.close();
		System.out.println(sb);
	}
}
