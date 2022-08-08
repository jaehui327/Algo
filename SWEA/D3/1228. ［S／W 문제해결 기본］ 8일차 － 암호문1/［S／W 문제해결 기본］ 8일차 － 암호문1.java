import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1228. 암호문 1
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
public class Solution {

	static int N;
	static List<Integer> board;

	static void command(int x, int y, List<Integer> s) {
		board.addAll(x, s);
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input/1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			board = new ArrayList<Integer>();

			StringTokenizer b = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				board.add(Integer.parseInt(b.nextToken()));
			}

			int command = Integer.parseInt(br.readLine());
			StringTokenizer c = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < command; i++) {
				c.nextToken();
				int x = Integer.parseInt(c.nextToken());
				int y = Integer.parseInt(c.nextToken());
				List<Integer> s = new ArrayList<Integer>();
				for (int j = 0; j < y; j++) {
					s.add(Integer.parseInt(c.nextToken()));
				}
				command(x, y, s);
			}

			sb.append("#");
			sb.append(t);
			sb.append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(board.get(i));
				sb.append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}
