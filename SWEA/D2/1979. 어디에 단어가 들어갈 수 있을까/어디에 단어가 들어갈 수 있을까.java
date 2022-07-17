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
            int N, K;
			N=sc.nextInt();
			K=sc.nextInt();
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			
			// 헹 우선
			for(int c = 0; c < N; c++) {
				int count = 0;
				for(int r = 0; r < N; r++) {
					if(board[c][r] == 0) {
						if (count == K) {
							answer += 1;
						}
						count = 0;
					} else {
						count += 1;
					}
				}
				if (count == K) {
					answer += 1;
				}
			}

			// 열 우선
			for(int r = 0; r < N; r++) {
				int count = 0;
				for(int c = 0; c < N; c++) {
					if(board[c][r] == 0) {
						if (count == K) {
							answer += 1;
						}
						count = 0;
					} else {
						count += 1;
					}
				}
				if (count == K) {
					answer += 1;
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}