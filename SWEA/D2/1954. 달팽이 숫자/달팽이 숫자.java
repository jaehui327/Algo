import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int[][] visited = new int[N][N];
			
			int num = 1;
			int d=0;
			int x=0;
			int y=0;
			board[x][y] = num++;
			
			while(true) {
				if(num>N*N) break;
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]==0) {
					board[nx][ny] = num++;
					x = nx;
					y = ny;
				} else {
					d = (d+1)%4;
					x += dir[d][0];
					y += dir[d][1];
					board[x][y] = num++;
				}
			}
			
			sb.append("#");
			sb.append(t);
			sb.append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(board[i][j]);
					sb.append(" ");
				}
				sb.append("\n");
			}
		}
		
		br.close();
		System.out.println(sb);
	}

}