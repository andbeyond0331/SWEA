package p2068_최대수구하기;

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
			int max = 0;
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i]>max) {
					max =arr[i];
				}
			}
			
			
			
			System.out.println("#"+tc+" "+max);
		}
	}
}
