import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16549. N과 M (1)
// https://www.acmicpc.net/problem/15649
public class Main {
	
	static StringBuilder sb;
	static int N, M;
	static int[] numbers;
	static boolean[] visited;
	
	static void permutation(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			numbers[idx] = i;
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
		numbers = new int[M];
		visited = new boolean[N + 1];
		
		permutation(0);
		
		br.close();
		System.out.println(sb);
	}
}
