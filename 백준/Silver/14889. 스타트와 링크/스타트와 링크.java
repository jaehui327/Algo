import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
// https://www.acmicpc.net/problem/14889
public class Main {
	
	static int N, min,  s, o;
	static int[] selected, others, xy;
	static int[][] board;
	
	private static void startLink(int idx, int start) {
		if (idx == N / 2) {
			get_power();
			return;
		}
		for (int i = start; i < N; i++) {
			selected[idx] = i;
			startLink(idx + 1, i + 1);
		}
	}
	
	private static void get_power() {
		int s_i = 0, o_i = 0;
		for (int i = 0; i < N; i++) {
			if(s_i < N / 2 && selected[s_i] == i) {
				s_i++;
			} else {
				others[o_i++] = i;
			}
		}
		s = 0; o = 0;
		get_sum_selected(0, 0);
		get_sum_others(0, 0);
		min = Math.min(min, Math.abs(s - o));
	}
	
	private static void get_sum_selected(int idx, int start) {
		if (idx == 2) {
			s += board[xy[0]][xy[1]] + board[xy[1]][xy[0]];
			return;
		}
		for (int i = start; i < N / 2; i++) {
			xy[idx] = selected[i];
			get_sum_selected(idx + 1, i + 1);
		}
	}
	
	private static void get_sum_others(int idx, int start) {
		if (idx == 2) {
			o += board[xy[0]][xy[1]] + board[xy[1]][xy[0]];
			return;
		}
		for (int i = start; i < N / 2; i++) {
			xy[idx] = others[i];
			get_sum_others(idx + 1, i + 1);
		}
	}
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		board = new int[N][N];
		selected = new int[N / 2];
		others = new int[N / 2];
		xy = new int[2];
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startLink(0, 0);
		
		sb.append(min);
		br.close();
		System.out.println(sb);
	}
}
