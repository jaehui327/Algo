import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, X, K, answer;

	private static void game(int a, int b) { // a와 b를 맞바꾸는 함수
		if (a == answer)
			answer = b; // a 위치에 간식이 들어있었다면 b 위치로 이동했으므로 answer 갱신
		else if (b == answer)
			answer = a; // b 위치에 간식이 들어있었다면 a 위치로 이동했으므로 answer 갱신
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 종의컵의 수
		X = Integer.parseInt(st.nextToken()); // 간식이 들어있는 종이컵의 위치
		K = Integer.parseInt(st.nextToken()); // 컵의 위치를 맞바꾸는 횟수

		answer = X; // 간식이 들어있는 위치를 answer에 저장
		for (int i = 0; i < K; i++) { // K번 맞바꾸기 수행
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			game(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken())); // 두 개의 종이컵 맞바꾸기
		}

		sb.append(answer).append("\n"); // 테스트 케이스 번호와 함께 간식의 위치 출력

		br.close();
		System.out.println(sb);
	}
}
