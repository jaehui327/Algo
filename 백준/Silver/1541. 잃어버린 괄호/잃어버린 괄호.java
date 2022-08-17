import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, "+-");
		int min = Integer.parseInt(st.nextToken());
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-') {
				break;
			} else if (s.charAt(i) == '+') {
				min += Integer.parseInt(st.nextToken());
			}
		}
		while (st.hasMoreTokens())
			min -= Integer.parseInt(st.nextToken());
		sb.append(min);
		
		br.close();
		System.out.println(sb);
	}
}
