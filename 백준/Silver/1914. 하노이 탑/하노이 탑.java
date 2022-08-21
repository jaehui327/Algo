import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static StringBuilder sb;
	static int N;
	
	private static void hanoi(int n, int current, int next) {
		if (n == 1) {
			sb.append(current).append(" ").append(next).append("\n");
			return;
		}
		hanoi(n - 1, current, 6 - current - next);
		sb.append(current).append(" ").append(next).append("\n");
		hanoi(n - 1, 6 - current - next, next);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		BigInteger result = new BigInteger("1");
		
		N = Integer.parseInt(br.readLine());
		if (N <= 20) {
			sb.append((int)Math.pow(2, N) - 1).append("\n");
			hanoi(N, 1, 3);
		}
		else {
			for (int i = 0; i < N; i++) {
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			sb.append(result);
		}
		
		br.close();
		System.out.println(sb);
	}
}
