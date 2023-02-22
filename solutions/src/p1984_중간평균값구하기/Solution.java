package p1984_중간평균값구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[10];
			
			int max = -1;
			int min = 10001;
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(max<arr[i]) {
					max = arr[i];
				}
				if(min>arr[i]) {
					min = arr[i];
				}
				
				sum+=arr[i];
			}
			sum-=max;
			sum-=min;
			System.out.println("#"+tc+" "+Math.round(sum/8.0));
		}
		
	}
}
