import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리
// https://www.acmicpc.net/problem/1992
public class Main {
	
	static int N;
	static char[][] board;
	static String s = "";
	
	private static void quadTree(int x, int y, int width) {
		 if (check(x, y, width)) {
			 s += board[y][x];
			 return;
		 }
		 s += "(";
		 width /= 2;
		 for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				quadTree(x + width * j, y + width * i, width);
			}
		}
		 s += ")";
	}
	
	private static boolean check(int x, int y, int width) {
		for (int i = y; i < y + width; i++) {
			for (int j = x; j < x + width; j++) {
				if (board[y][x] != board[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		quadTree(0, 0, N);
		sb.append(s);
		
		br.close();
		System.out.println(sb);
	}
}
