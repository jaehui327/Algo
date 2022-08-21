import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int last = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				queue.offer(x);
				last = x;
				break;
			case "pop":
				if (!queue.isEmpty()) sb.append(queue.poll()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (queue.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if (!queue.isEmpty()) sb.append(queue.peek()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "back":
				if (!queue.isEmpty()) sb.append(last).append("\n");
				else sb.append(-1).append("\n");
				break;
			default:
				break;
			}
		}

		br.close();
		System.out.println(sb);
	}
}
