import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복된 숫자
// https://www.acmicpc.net/problem/15719
public class Main {

	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (visited[x]) sb.append(x);
			visited[x] = true;
		}
		
		br.close();
		System.out.println(sb);
	}
}
