import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean end;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = input[j] - '0';
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		br.close();
	}
	
	private static void dfs(int n) {
		if (n == 9 * 9) {
			end = true;
			return;
		}
		
		int x = n % 9;
		int y = n / 9;
		if (board[y][x] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (!isValid(x, y, i)) continue;
				board[y][x] = i;
				dfs(n + 1);
				if (end) return;
				board[y][x] = 0;
			}
		} else {
			dfs(n + 1);
		}
	}

	private static boolean isValid(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[y][i] == num || board[i][x] == num) return false;
		}
		
		for (int r = y / 3 * 3; r < y / 3 * 3 + 3; r++) {
			for (int c = x / 3 * 3; c < x / 3 * 3 + 3; c++) {
				if (board[r][c] == num) return false;
			}
		}
		
		return true;
	}
}
