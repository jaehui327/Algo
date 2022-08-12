import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 요리사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
public class Solution {

	static int N, min, s, o;
	static int[][] board;
	static int[] selected, others, xy;
	
	private static void cook(int idx, int start) {
		if (idx == N / 2) {
			get_taste();
			return;
		}
		for (int i = start; i < N; i++) {
			selected[idx] = i;
			cook(idx + 1, i + 1);
		}
	}
	
	private static void get_taste() {
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

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			board = new int[N][N];
			selected = new int[N / 2];
			others = new int[N / 2];
			xy = new int[2];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cook(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
