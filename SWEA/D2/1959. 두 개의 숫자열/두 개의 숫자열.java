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
            int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			int count = Math.abs(N - M);
			int width = Math.min(N, M);
			int sum = 0;
			if (N > M) {
				for(int i = 0; i <= count; i++) {
					int temp = 0;
					for(int j = 0; j < width; j++) {
						temp += A[j + i] * B[j];
					}
					sum = Math.max(sum, temp);
				}
			} else if (N < M) {
				for(int i = 0; i <= count; i++) {
					int temp = 0;
					for(int j = 0; j < width; j++) {
						temp += A[j] * B[j + i];
					}
					sum = Math.max(sum, temp);
				}
			} else {
				int temp = 0;
				for(int j = 0; j < width; j++) {
					temp += A[j] * B[j];
				}
				sum = Math.max(sum, temp);
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}