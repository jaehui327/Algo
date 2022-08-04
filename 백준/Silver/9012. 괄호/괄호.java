import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main{

	static HashMap<Character, Character> map = new HashMap<Character, Character>() {{
		put('(', ')'); put('[', ']'); put('{', '}'); put('<', '>');
	}};
	
	static String isValidBracket(char[] bracket) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<bracket.length; i++) {
			if(map.containsKey(bracket[i])) stack.push(bracket[i]);
			else {
				if(!stack.isEmpty() && bracket[i] == map.get(stack.peek())) stack.pop();
				else return "NO";
			}
		}
		if(stack.isEmpty()) return "YES";
		else return "NO";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			char[] bracket = br.readLine().toCharArray();
			
			sb.append(isValidBracket(bracket));
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}
