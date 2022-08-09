import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, result;
	static boolean[][] isBlack;
	
	static void paper(int x, int y) {
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 10; k++) {
				if(isBlack[x + j][y + k]) continue;
				else {
					isBlack[x + j][y + k] = true;
					result++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		isBlack = new boolean[100][100];
		result = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			paper(x, y);
		}
		sb.append(result);
		
		br.close();
		System.out.println(sb);
	}
}
