import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1158. 요세푸스 문제
// https://www.acmicpc.net/problem/1158
public class Main {
	
	static Queue<Integer> josephus(int K, Queue<Integer> queue) {
		Queue<Integer> result = new LinkedList<Integer>();
		while(!queue.isEmpty()) {
			for(int i = 1; i <= K; i++) {
				if(i == K) result.offer(queue.poll());
				else queue.offer(queue.poll());
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		Queue<Integer> result = josephus(K, queue);
		sb.append("<");
		while(result.size() > 1) {
			sb.append(result.poll());
			sb.append(", ");
		}
		sb.append(result.poll());
		sb.append(">");
		
		br.close();
		System.out.println(sb);
	}
}
