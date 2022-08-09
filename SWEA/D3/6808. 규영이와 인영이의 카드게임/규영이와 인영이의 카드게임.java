import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6808. 규영이와 인영이의 카드게임
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
public class Solution {

	static int N = 9, win, lose;
	static int[] gyuyoung, inyoung;
	static boolean[] visited;
	
	static void game(int cnt, int gs, int is) {
		if(cnt == N) {
			if (gs > is) win++;
			else if (gs < is) lose++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			int n = inyoung[i];
			if (visited[n]) continue;
			visited[n] = true;
			
			int score = n + gyuyoung[cnt];
			if(n > gyuyoung[cnt]) game(cnt + 1, gs, is + score);
			else if (n < gyuyoung[cnt]) game(cnt + 1, gs + score, is);
			else game(cnt + 1, gs, is);
			
			visited[n] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input/6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win = 0;
			lose = 0;
			gyuyoung = new int[N];
			inyoung = new int[N];
			visited = new boolean[N * 2 + 1];
			boolean[] appeared = new boolean[N * 2 + 1];
			for(int i = 0; i < N; i++) {
				gyuyoung[i] = Integer.parseInt(st.nextToken());
				appeared[gyuyoung[i]] = true;
			}
			int idx = 0;
			for(int i = 1; i <= N * 2; i++) {
				if(!appeared[i]) inyoung[idx++] = i;
			}
			
			game(0, 0, 0);
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(win);
			sb.append(" ");
			sb.append(lose);
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}
