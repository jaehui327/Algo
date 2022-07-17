import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = 9;
            int[][] board = new int[n][n];
            boolean verification = true;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            
            for(int i = 0; i < n; i+=3) {
                for(int j = 0; j < n; j+=3) {
                    int[] arr = new int[n];
                    int r = i + 3;
                    int c = j + 3;
                    
                    for(int a = i; a < r; a++) {
                        for(int b = j; b < c; b++) {
                            arr[board[a][b] - 1]++;
                        }
                    }
                    for(int k = 0; k < n; k++) {
                        if(arr[k] == 0) {
                            verification = false;
                            break;
                        }
                    }
                }
            }
            
            for (int i = 0; i < 9; i++) {
                int[] arr = new int[n];
                for(int j = 0; j < n; j++) {
                    arr[board[i][j] - 1]++;
                }
                 for(int k = 0; k < n; k++) {
                     if(arr[k] == 0) {
                        verification = false;
                        break;
                    }
                }
            }
            
             for (int i = 0; i < 9; i++) {
                int[] arr = new int[n];
                for(int j = 0; j < n; j++) {
                    arr[board[j][i] - 1]++;
                }
                 for(int k = 0; k < n; k++) {
                     if(arr[k] == 0) {
                        verification = false;
                        break;
                    }
                }
            }
            
            if(verification == true) {
                System.out.printf("#%d %d\n", test_case, 1);
            } else {
                System.out.printf("#%d %d\n", test_case, 0);
            }
		}
	}
}