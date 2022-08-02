import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
//				StringTokenizer b = new StringTokenizer(br.readLine(), " ");
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = s.charAt(j)-'0';
				}
			}
			int sum = 0;
			int width = 1;
			int start = N/2;
			for(int i=0; i<N; i++) {
				for(int j=0; j<width; j++) {
					sum += board[i][j+start];
				}
				if(i<N/2) {
					width += 2; 
					start--;
				}
				else {
					width -= 2; 
					start++;
				}
			}

			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(sum);
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}