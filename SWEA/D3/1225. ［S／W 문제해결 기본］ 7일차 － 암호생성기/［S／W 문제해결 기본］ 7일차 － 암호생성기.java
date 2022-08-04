import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1225. 암호생성기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int temp = 0;
			outer:while(true) {
				for(int i=1; i<=5; i++) {
					temp = queue.poll()-i;
					if(temp<=0) {
						queue.offer(0);
						break outer;
					}
					queue.offer(temp);
				}
			}
			
			sb.append("#");
			sb.append(T);
			sb.append(" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()); 
				sb.append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
	
}
