import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int L, C;
	static String[] board, selected;

	private static void make(int idx, int start) {
		if (idx == L) {
			isAvailable();
			return;
		}
		for (int i = start; i < C; i++) {
			selected[idx] = board[i];
			make(idx + 1, i + 1);
		}
	}
	
	private static void isAvailable() {
		int vowel = 0;
		for (int i = 0; i < selected.length; i++) {
			if ("aeiou".contains(selected[i])) vowel++;
		}
		if (vowel >= 1 && L - vowel >= 2) {
			for (int i = 0; i < selected.length; i++) {
				sb.append(selected[i]);
			}
			sb.append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = br.readLine().split(" ");
		selected = new String[L];

		Arrays.sort(board);

		make(0, 0);

		br.close();
		System.out.println(sb);
	}
}
