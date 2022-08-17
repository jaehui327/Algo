import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static Stack<String> stack;
	
	private static int makeMin() {
		int result = 0;
		int temp = 0;
		while(!stack.isEmpty()) {
			String s = stack.pop();
			if (s.equals("-")) {
				result -= temp;
				temp = 0;
			} else if (!s.equals("+")) {
				temp += Integer.parseInt(s);
			}
		}
		return result + temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		stack = new Stack<>();
		String[] s = br.readLine().split("(?<=[+-])|(?=[+-])");
		for (int i = 0; i < s.length; i++) {
			stack.add(s[i]);
		}
		sb.append(makeMin());
		
		br.close();
		System.out.println(sb);
	}
}
