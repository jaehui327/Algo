import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					int temp = 0;
					for(int a = 0; a < M; a++) {
						for(int b = 0; b < M; b++) {
							temp += board[i + a][j + b];
						}
					}
					answer = Math.max(answer, temp);
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}