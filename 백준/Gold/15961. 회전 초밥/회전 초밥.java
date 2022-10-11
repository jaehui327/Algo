import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list = new int[N + k - 1];
		
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k-1; i++) {
			list[N++] = list[i];
		}

		int[] eaten = new int[d + 1];
		int max = 1;
		eaten[c] += 1;
		
		int start = 0;
		for (int i = start; i < k; i++) {
			if(eaten[list[i]] == 0) {
				max += 1;
			}
			eaten[list[i]] += 1;
		}
		
		start = 0;
		int end = k;
		
		int result = max;
		for (int i = end; i < list.length; i++) {
			eaten[list[start]] -= 1;
			if(eaten[list[start]] == 0) {
				result -= 1;
			}
			if(eaten[list[i]] == 0) 
				result += 1;
			eaten[list[i]] += 1;
			max = Math.max(max, result);
			start += 1;
		}
		
		System.out.println(max);
	}
}