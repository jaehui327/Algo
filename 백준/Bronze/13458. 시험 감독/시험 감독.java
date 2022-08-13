import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시험 감독
// https://www.acmicpc.net/problem/13458
public class Main {

	static int N, B, C;
	static int[] A;
	
	private static long exam_supervisor() {
		long supervisor = 0;
		for (int i = 0; i < N; i++) {
			supervisor += 1;
			if (A[i] - B > 0)
				supervisor += (A[i] - B) % C == 0 ? (A[i] - B) / C : (A[i] - B) / C + 1;
		}
		return supervisor;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s.nextToken());
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		sb.append(exam_supervisor());
		br.close();
		System.out.println(sb);
	}
}
