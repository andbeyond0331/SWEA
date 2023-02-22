package d3.p3499_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
		
			String[] card1 = new String[N%2==0?N/2:N/2+1];
			String[] card2 = new String[N/2];
			int idx1 = 0;
			int idx2 = 0;
			
			for (int j = 0; j < N; j++) {
				if(N%2==0) {
					if(j<N/2) {
						card1[idx1++] = st.nextToken();
					}else {
						card2[idx2++] = st.nextToken();
					}
				}else {
					if(j<N/2+1) {
						card1[idx1++] = st.nextToken();
					}else {
						card2[idx2++] = st.nextToken();
					}
					
				}
				
			}
			sb.append("#");
			sb.append(i);
			sb.append(" ");
			for (int j = 0; j < card2.length; j++) {
				sb.append(card1[j]);
				sb.append(" ");
				sb.append(card2[j]);
				sb.append(" ");
			}
			if(N%2!=0) {
				sb.append(card1[card1.length-1]);
			}else {
				
				sb.delete(sb.length()-1, sb.length());
			}
			sb.append("\n");
			
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
