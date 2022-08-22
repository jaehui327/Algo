import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine(); // 문장 입력 받기
		int i = 0; // 인덱스 위치 - 시작점 0
		String answer = ""; // 정답 String
		while (i < s.length()) { // 문장 끝까지 훑어보기
			answer += s.charAt(i); // 현재 인덱스 위치의 char 값 정답에 추가
			switch (s.charAt(i)) {
			case 'a': case 'e': case'i': case 'o': case 'u': // 모음이라면
				i += 3; // 현재 문자, p, 현재 문자 - 3개의 문자를 건너 뛰어 줌
				break;
			default: // 자음이라면
				i++; // 다음 문자를 봄
				break;
			}
		}
		sb.append(answer); // 정답 출력
		
		br.close();
		System.out.println(sb);
	}
}
