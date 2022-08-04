import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

//1218. 괄호 짝짓기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
	
public class Solution {
	
	static HashMap<Character, Character> map = new HashMap<Character, Character>() {{
		put('(', ')'); put('[', ']'); put('{', '}'); put('<', '>');
	}};
	
	static int isValidBracket(int N, char[] bracket) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<N; i++) {
			if(map.containsKey(bracket[i])) stack.push(bracket[i]);
			else {
				if(!stack.isEmpty() && bracket[i] == map.get(stack.peek())) stack.pop();
				else return 0;
			}
		}
		if(stack.isEmpty()) return 1;
		else return 0;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] bracket = br.readLine().toCharArray();
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(isValidBracket(N, bracket));
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}