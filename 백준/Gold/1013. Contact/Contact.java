import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) 
		    if (Pattern.matches("((100+1+)?(01)?)+", br.readLine())) sb.append("YES").append("\n");
		    else sb.append("NO").append("\n");
		System.out.println(sb);
		br.close();
	}
}