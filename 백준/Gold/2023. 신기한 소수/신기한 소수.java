import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb;
	static int[] numbers;
	static int N;

	static void prime(int cnt, int num) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]);
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			numbers[cnt] = i;
			int temp = (int) (num * 10 + i);
			if (temp != 1 && isPrime(temp))
				prime(cnt + 1, temp);
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		prime(0, 0);

		br.close();
		System.out.println(sb);
	}

}
