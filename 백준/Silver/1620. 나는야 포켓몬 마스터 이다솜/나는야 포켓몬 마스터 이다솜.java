import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String input;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] pocketmons = new String[N + 1];
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 1; i <= N; i++) {
		    input = br.readLine();
		    pocketmons[i] = input;
		    map.put(input, i);
		}
		
		for (int i = 0; i < M; i++) {
		    input = br.readLine();
		    if (Character.isAlphabetic(input.charAt(0))) sb.append(map.get(input)).append("\n");
		    else sb.append(pocketmons[Integer.parseInt(input)]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}