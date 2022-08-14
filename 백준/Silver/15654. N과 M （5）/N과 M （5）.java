import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5)
// https://www.acmicpc.net/problem/15654
public class Main {

	static StringBuilder sb;
	static int N, M;
	static int[] input, numbers;
	static boolean[] visited;
	
	private static void permutation(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			numbers[idx] = input[i];
			visited[i] = true;
			permutation(idx + 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[M];
		visited = new boolean[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(input);
		
		permutation(0);
		
		br.close();
		System.out.println(sb);
	}
}
