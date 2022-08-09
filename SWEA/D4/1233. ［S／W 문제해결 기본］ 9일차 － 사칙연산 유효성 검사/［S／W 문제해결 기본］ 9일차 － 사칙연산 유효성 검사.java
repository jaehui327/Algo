import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1233. 사칙연산 유효성 검사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
public class Solution {
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input/1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int half = N / 2;
			int result = 1;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if(idx <= half && c > '0') {
					result = 0;
				} else if(idx > half && c < '0') {
					result = 0;
				}
			}
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(result);
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}
