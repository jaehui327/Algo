import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12891. DNA 비밀번호
// https://www.acmicpc.net/problem/12891
public class Main {

	static char[] s = new char[1_000_000];
	static int[] appear = new int[4];
	static int[] count = new int[4];
	static char[] dna = { 'A', 'C', 'G', 'T' };

	private static int password(int P, int N) {
		int result = 0;
		int windowStart = 0;
		

		for (int i = 0; i < N; i++) {
			upCount(s[i]);

			if (i >= P - 1) {
				if(check()) result++;
				// 범위 벗어난 것 삭제
				downCount(s[windowStart]);
				windowStart++;
			}

		}

		return result;
	}
	
	private static void upCount(char c) {
		for (int j = 0; j < 4; j++) {
			if (c == dna[j]) {
				count[j]++;
				break;
			}
		}
	}
	
	private static void downCount(char c) {
		for (int j = 0; j < 4; j++) {
			if (c == dna[j]) {
				count[j]--;
				break;
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (count[i] < appear[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		s = br.readLine().toCharArray();

		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			appear[i] = Integer.parseInt(st2.nextToken());

		br.close();
		System.out.println(password(P, N));
	}

}