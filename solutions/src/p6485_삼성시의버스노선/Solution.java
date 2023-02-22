package p6485_삼성시의버스노선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] As = new int[N];
			int[] Bs = new int[N];
			
			for(int ns = 0; ns < N; ns++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				As[ns] = A;
				Bs[ns] = B;
			
			}
			
			int P = Integer.parseInt(br.readLine());
			
//			int[] Cs = new int[P];
			List<Integer> Cs = new ArrayList<>();
			
			for(int ps = 0; ps < P; ps ++) {
				Cs.add(Integer.parseInt(br.readLine()));
			}
			
			// 버스노선 N개 + i번째 버스노선은 번호가 A[i] 이상
			// 
//			Cs.sort(Comparator.naturalOrder());
			int[] count = new int[P];
			
			for(int cnt = 0; cnt < N; cnt++) { 
//				int from = As[cnt];
//				int to = Bs[cnt];
//				for(int clist = 0; clist < Cs.size(); clist++) {
//					if(Cs.get(clist) >= from)
//				}
				for(int clist = 0; clist< Cs.size(); clist++) {
					if(Cs.get(clist)>=As[cnt] && Cs.get(clist) <= Bs[cnt]) {
						count[clist]++;
					}
				}
			}
			
			String res = "";
			for(int i = 0; i < Cs.size();i ++) {
				if(i==Cs.size()-1) {
					
					res+=count[i];
				}else {
					res+=count[i]+" ";
				}
				
			}
			
			
			
			
			System.out.println("#" + test + " " + res );
		}
	}
}
