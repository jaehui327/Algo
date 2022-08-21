import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, result;
	static int[] board;
	
	private static void nQueen(int r) {
		if (r == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			board[r] = i;
			if(isAvailable(r)) nQueen(r + 1);
		}
	}
	
	private static boolean isAvailable(int r) {
		for (int i = 0; i < r; i++) {
			if (board[i] == board[r] || r - i == Math.abs(board[r] - board[i])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		board = new int[N];

		nQueen(0);
		sb.append(result);

		br.close();
		System.out.println(sb);
	}
}
