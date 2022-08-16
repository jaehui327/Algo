import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달
// acmicpc.net/problem/2839
public class Main {

	static int N;
	
	private static int sugarDelivery() {
		int result = 0;
		while(N != 0) {
			if (N < 3 || N == 4) return -1;
			if (N % 5 == 0) N -= 5;
			else if (N % 3 == 0) N -= 3;
			else {
				if (N > 5) N -= 5;
				else N -= 3;
			}
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		sb.append(sugarDelivery());
		
		br.close();
		System.out.println(sb);
	}
}
