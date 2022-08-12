import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치킨 배달
// https://www.acmicpc.net/problem/15686
public class Main {

	static int N, M, min;
	static int[] selected;
	static int[][] board;
	static ArrayList<int[]> house, chiken;

	private static void chiken_distance(int idx, int start) {
		if (idx == M) {
			get_distance();
			return;
		}
		for (int i = start; i < chiken.size(); i++) {
			selected[idx] = i;
			chiken_distance(idx + 1, i + 1);
		}
	}

	private static void get_distance() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < selected.length; j++) {
				temp = Math.min(temp, Math.abs(house.get(i)[0] - chiken.get(selected[j])[0]) + Math.abs(house.get(i)[1] - chiken.get(selected[j])[1]));
			}
			sum += temp;
		}
		min = Math.min(min, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		
		min = Integer.MAX_VALUE;
		board = new int[N ][N];
		selected = new int[M];
		house = new ArrayList<>();
		chiken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					house.add(new int[] { i, j });
				else if (board[i][j] == 2)
					chiken.add(new int[] { i, j });
			}
		}

		chiken_distance(0, 0);
		sb.append(min);

		br.close();
		System.out.println(sb);
	}
}
