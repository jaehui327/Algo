import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 2493. 탑
// https://www.acmicpc.net/problem/2493
public class Main {

	static int top(Stack<int[]> stack, int height) {
		while(!stack.empty()) {
			if(height > stack.peek()[0]) stack.pop();
			else return stack.peek()[1];
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		int[] result = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			result[i] = top(stack, height);
			stack.push(new int[] {height , i + 1 });
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		
		br.close();
		System.out.println(sb);
	}

}
