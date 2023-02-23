package d3.p7102_준홍이의카드놀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int min = Math.min(N, M);
			int max = Math.max(N, M);
			
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			for(int i = min+1; i <= max+1; i++) {
				sb.append(i);
				if(i==max+1) {
					
					sb.append("\n");
				}else {
					
					sb.append(" ");
				}
				
			}
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
