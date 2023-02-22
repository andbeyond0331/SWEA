package p1860_진기의최고급붕어빵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// N명의 사람에게 M초의 시간으로 K개 붕어빵 만들어서
//			int[] time = new int[N];
			List<Integer> list = new ArrayList<>();
			StringTokenizer times = new StringTokenizer(br.readLine(), " ");
			for(int t = 0; t < N; t++) {
//				time[t] = Integer.parseInt(times.nextToken());
				list.add(Integer.parseInt(times.nextToken()));
			}
			
			list.sort(Comparator.naturalOrder());
			
			int count = 0;
			
			boolean flag = true;
			
			for(int time = 0; time <= list.get(list.size()-1); time++) {
				if(time%M==0 && time!=0) {
					count+=K;
				}
//				System.out.println("time: " + time + ", count : "+ count);
				for(int l = 0; l < list.size(); l ++) {
					if(list.get(l)==time) {
						if(count>0) {
							
							count--;
						}else {
							flag = false;
							break;
						}
						
					}
				}
				
				if(!flag) {
					break;
				}
			}
			
			if(flag) {
				System.out.println("#" + test + " Possible");
			}else {
				System.out.println("#" + test + " Impossible");
			}
			
			
		}
	}
}
