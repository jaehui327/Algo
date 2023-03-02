import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, max;
	static char[] board;

	private static void addBracket(int idx, int sum) {
		if (idx >= N) {
			max = Math.max(max, sum);
			return;
		}

		addBracket(idx + 2, calucation(sum, board[idx - 1], board[idx] - '0'));
		
		if (idx + 2 < N) {
			int right = calucation(board[idx] - '0', board[idx + 1], board[idx + 2] - '0');
			addBracket(idx + 4, calucation(sum, board[idx - 1], right));
		}
		
	}

	private static int calucation(int a, char operation, int b) {
		if (operation == '+') {
			return a + b;
		} else if (operation == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;

		board = br.readLine().toCharArray();

		if (N == 1) {
			System.out.println(board[0]);
		} else {
			addBracket(2, board[0] - '0');
			System.out.println(max);
		}

		br.close();
	}

}
