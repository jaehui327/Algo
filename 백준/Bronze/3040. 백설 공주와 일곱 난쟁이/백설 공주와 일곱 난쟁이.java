import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 3040. 백설 공주와 일곱 난쟁이
// https://www.acmicpc.net/problem/3040
public class Main {
	
	static int N = 9, M = 7;
	static int[] board, numbers;
	static StringBuilder sb;
	
	private static void combination(int cnt, int start, int sum) {
		if (cnt == M) {
			if (sum == 100) {
				for (int i = 0; i < M; i++) {
					sb.append(numbers[i]).append("\n");
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = board[i];
			combination(cnt + 1, i + 1, sum + board[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		board = new int[N];
		numbers = new int[M];
		for(int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0, 0);
		
		br.close();
		System.out.println(sb);
	}
}
