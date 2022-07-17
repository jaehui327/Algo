import java.util.Scanner;

class Solution
{
    public static int[][] rotation(int n, int[][] board) {
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = board[n-j-1][i];
			}
		}
		return result;
	}
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = sc.nextInt();
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int[][] board_90 = rotation(N, board);
			int[][] board_180 = rotation(N, board_90);
			int[][] board_270 = rotation(N, board_180);
			
			System.out.println("#"+test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board_90[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(board_180[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(board_270[i][j]);
				}
				System.out.println();
			}
		}
	}
}