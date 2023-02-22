package p1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = 0;
		while(list.size()>0) {
			int temp = K;
			
			if(list.size()>1) {
				while(temp>1) {
					if(idx<list.size()-1) {
						idx++;
					}else if(idx==list.size()-1) {
						idx = 0;
						
					}
					temp--;
				}
				
				sb.append(list.get(idx) + ", ");
				list.remove(idx);
				if(idx==list.size()) {
					idx = 0;
				}
			}else {
				sb.append(list.get(0)+">");
				list.remove(idx);
				
				
			}
		}
		System.out.println(sb);
	}
}
